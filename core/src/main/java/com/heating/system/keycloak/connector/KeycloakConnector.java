package com.heating.system.keycloak.connector;

import com.heating.system.keycloak.config.properties.KeycloakProperties;
import com.heating.system.keycloak.model.dto.CredentialDto;
import com.heating.system.keycloak.model.request.*;
import com.heating.system.keycloak.model.response.KeycloakLoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Log4j2
@Service
@RequiredArgsConstructor
public class KeycloakConnector {

    private final KeycloakClient keycloakClient;
    private final KeycloakProperties keycloakProperties;

    public KeycloakLoginResponse loginAdmin() {
        return keycloakClient.loginAdmin(KeycloakLoginAdminRequest.builder()
                .password(keycloakProperties.getPassword())
                .username(keycloakProperties.getLogin())
                .client_id("admin-cli")
                .grant_type("password")
                .build()).getBody();
    }

    public KeycloakLoginResponse login(String username, String password) {
        return keycloakClient.login(KeycloakLoginRequest.builder()
                .password(password)
                .username(username)
                .client_secret(keycloakProperties.getClientSecret())
                .client_id(keycloakProperties.getClientId())
                .grant_type("password")
                .build()).getBody();
    }

    public KeycloakLoginResponse refreshToken() {
        log.info("Refresh token for admin user - invoked");
        return keycloakClient.refreshToken(KeycloakRefreshRequest.builder()
                .refresh_token(keycloakProperties.getRefreshToken())
                .client_id(keycloakProperties.getClientId())
                .grant_type("refresh_token")
                .build()).getBody();
    }

    public String registerUser(String email, String password, String firstName, String lastName, String bearerToken) {
        KeycloakRegisterRequest request = KeycloakRegisterRequest.builder()
                .email(email)
                .username(email)
                .firstName(firstName)
                .lastName(lastName)
                .credentials(Collections.singletonList(CredentialDto.builder()
                        .value(password)
                        .build()))
                .build();
        var response = keycloakClient.registerUser(request, "Bearer " + bearerToken);
        return response.headers().get("Location").toString().substring(response.headers().get("Location").toString().lastIndexOf('/') + 1).replace("]", ""); //userId
    }

    public void updateUser(String email, String firstName, String lastName, String userId) {
        log.info("updateUser - invoked: userId {}", userId);
        UpdateUserRequest request = UpdateUserRequest.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        keycloakClient.updateUser(userId, request);
    }

    public void sendVerifyEmail(String userId) {
        log.info("Sending activation email");
        keycloakClient.sendVerifyEmail(userId, keycloakProperties.getClientId());
    }
}
