package com.heating.system.keycloak.connector;

import com.heating.system.keycloak.config.FeignConfig;
import com.heating.system.keycloak.model.request.*;
import com.heating.system.keycloak.model.response.KeycloakLoginResponse;
import feign.Headers;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "keycloak", url = "${app.keycloak.api-path}", configuration = FeignConfig.class)
public interface KeycloakClient {

    @PostMapping(value = "realms/master/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> loginAdmin(KeycloakLoginAdminRequest request);

    @PostMapping(value = "realms/${app.keycloak.realm}/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> login(KeycloakLoginRequest request);

    @PostMapping(value = "realms/master/protocol/openid-connect/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @Headers("Content-Type: application/x-www-form-urlencoded")
    ResponseEntity<KeycloakLoginResponse> refreshToken(KeycloakRefreshRequest request);

    @PostMapping(value = "admin/realms/${app.keycloak.realm}/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-Type: application/json")
    Response registerUser(KeycloakRegisterRequest request, @RequestHeader("Authorization") String bearerToken);

    @PutMapping(value = "admin/realms/${app.keycloak.realm}/users/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Response updateUser(@PathVariable("userId") String userId, UpdateUserRequest request);

    @PutMapping(value = "admin/realms/${app.keycloak.realm}/users/{userId}/send-verify-email", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> sendVerifyEmail(@PathVariable("userId") String userId, @RequestParam(value = "client_id", required = false) String clientId);

}
