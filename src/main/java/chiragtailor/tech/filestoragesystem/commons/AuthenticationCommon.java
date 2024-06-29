package chiragtailor.tech.filestoragesystem.commons;

import chiragtailor.tech.filestoragesystem.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AuthenticationCommon {
    private RestTemplate restTemplate;

    public AuthenticationCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token){

        ResponseEntity<UserDto> dto = restTemplate.getForObject(
                "http://localhost:8283/user/login" + token,
                null,
                UserDto.class
        );

        if (dto.getBody() == null){
            return null;
        }

        return dto.getBody();
    }
}
