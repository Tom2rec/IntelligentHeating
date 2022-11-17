package com.heating.system.keycloak.connector;

import com.heating.system.keycloak.config.FeignConfig;
import com.heating.system.keycloak.model.request.KeycloakLoginRequest;
import com.heating.system.keycloak.model.request.KeycloakRefreshRequest;
import com.heating.system.keycloak.model.request.KeycloakRegisterRequest;
import com.heating.system.keycloak.model.request.KeycloakRoleRequest;
import com.heating.system.keycloak.model.response.KeycloakLoginResponse;
import feign.Headers;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "keycloak", url = "${app.keycloak.api-path}", configuration = FeignConfig.class)
public interface KeycloakClient {

    @PostMapping(value = "realms/master/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> loginAdmin(KeycloakLoginRequest request);

    @PostMapping(value = "realms/${app.keycloak.realm}/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> login(KeycloakLoginRequest request);

    @PostMapping(value = "realms/master/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> refreshToken(KeycloakRefreshRequest request);

    @PostMapping(value = "admin/realms/${app.keycloak.realm}/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    Response registerUser(KeycloakRegisterRequest request);

    @PutMapping(value = "admin/realms/${app.keycloak.realm}/users/{userId}/execute-actions-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> executeActionsEmail(@PathVariable("userId") String userId, @RequestParam(value = "client_id", required = false) String clientId,
                                             @RequestParam(value = "redirect_uri", required = false) String redirectUri);

    @PutMapping(value = "admin/realms/${app.keycloak.realm}/users/{userId}/execute-actions-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> executeActionsEmail(@PathVariable("userId") String userId, @RequestParam(value = "client_id", required = false) String clientId);

    @PostMapping(value = "admin/realms/${app.keycloak.realm}/roles", consumes = MediaType.APPLICATION_JSON_VALUE)
    Response addRole(KeycloakRoleRequest request);

    @PutMapping(value = "admin/realms/${app.keycloak.realm}/users/{userId}/send-verify-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> sendVerifyEmail(@PathVariable("userId") String userId, @RequestParam(value = "client_id", required = false) String clientId);

}
