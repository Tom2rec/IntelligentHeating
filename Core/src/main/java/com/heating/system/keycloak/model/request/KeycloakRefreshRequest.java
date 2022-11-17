package com.heating.system.keycloak.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakRefreshRequest {
    private String grant_type;
    private String client_id;
    private String refresh_token;
}

