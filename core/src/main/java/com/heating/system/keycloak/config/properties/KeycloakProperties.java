package com.heating.system.keycloak.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ConfigurationProperties("app.keycloak")
@Component
@Data
@Validated
public class KeycloakProperties {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String apiPath;
    @NotBlank
    private String redirectUri;
    @NotBlank
    private String clientId;
    @NotBlank
    private String clientSecret;
    @NotBlank
    private String realm;
    private String accessToken;
    private String refreshToken;
    private LocalDateTime refreshTokenValidDate;
}
