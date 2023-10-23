package se331.rest.lab.security.authentication;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import se331.rest.lab.entity.Advisor;
import se331.rest.lab.entity.Student;
import se331.rest.lab.security.authorization.Token;
import se331.rest.lab.security.authorization.TokenRepository;
import se331.rest.lab.security.authorization.TokenType;
import se331.rest.lab.security.configuraton.JwtService;
import se331.rest.lab.security.identity.Role;
import se331.rest.lab.security.identity.User;
import se331.rest.lab.security.identity.UserRepository;
import se331.rest.lab.util.LabMapper;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerStudent(RegisterRequest request) {
        Student student = Student.builder()
                .studentID(request.getUsername()) // Map StudentID from request to studentID in Student table
                .name(request.getFirstname())
                .surname(request.getLastname())
                .id(studentRepository.count() + 1)
                .build();

        User user = User.builder()
                .studentId(request.getStudentId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .username(request.getUsername())
                .student(student)
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_STUDENT))
                .build();
        studentRepository.save(student);
        var savedUser = repository.save(user);
        student.setUser(user);
        studentRepository.save(student);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .student(LabMapper.INSTANCE.getStudentAuthDTO(user.getStudent()))
                .build();
    }

    public AuthenticationResponseAdvisor registerAdvisor(RegisterRequest request) {
        Advisor advisor = Advisor
                .builder()
                .advisorID(request.getAdvisorID()) // Map advisorID from request to advisorID in Advisor table
                .name(request.getFirstname())
                .surname(request.getLastname())
                .id(advisorRepository.count() + 1)
                .build();

        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .username(request.getUsername())
                .advisor(advisor)
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_ADVISOR))
                .build();
        advisorRepository.save(advisor);
        var savedUser = repository.save(user);
        advisor.setUser(user);
        advisorRepository.save(advisor);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponseAdvisor.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .advisor(LabMapper.INSTANCE.getAdvisorAuthDTO(user.getAdvisor()))
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));
        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        // revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        // return AuthenticationResponse.builder()
        // .accessToken(jwtToken)
        // .refreshToken(refreshToken)
        // .build();
        // }
        if (user.getRoles().equals("ROLE_STUDENT")) {
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .student(LabMapper.INSTANCE.getStudentAuthDTO(user.getStudent()))
                    .build();
        } else {
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .advisor(LabMapper.INSTANCE.getAdvisorAuthDTO(user.getAdvisor()))
                    .build();
        }
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            User user = this.repository.findByUsername(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                AuthenticationResponse authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}