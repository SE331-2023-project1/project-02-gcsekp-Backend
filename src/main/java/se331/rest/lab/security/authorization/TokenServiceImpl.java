package se331.rest.lab.security.authorization;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    final TokenDao tokenDao;

    @Override
    @Transactional
    public void save(Token token) {
        tokenDao.save(token);
    }
}
