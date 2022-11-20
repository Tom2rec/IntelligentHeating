package com.heating.system.keycloak.config;

import com.heating.system.keycloak.config.properties.KeycloakProperties;
import lombok.AllArgsConstructor;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class KeycloakConfig {

    private final KeycloakProperties properties;

    @Bean
    public RealmResource realm() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(properties.getApiPath())
                .realm(properties.getRealm())
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId(properties.getClientId())
                .clientSecret(properties.getClientSecret())
                .build();
        return keycloak.realm(properties.getRealm());
    }
}
