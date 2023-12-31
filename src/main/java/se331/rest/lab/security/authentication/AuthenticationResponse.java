package se331.rest.lab.security.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.lab.dto.AdvisorAuthDTO;
import se331.rest.lab.dto.StudentAuthDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private AdvisorAuthDTO advisor;
    private StudentAuthDTO student;
}
