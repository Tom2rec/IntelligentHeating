package com.heating.system.keycloak.model.request;

import com.heating.system.keycloak.model.dto.CredentialDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakRegisterRequest {
    private final boolean enabled = true;
    private final String emailVerified = "";
    private List<CredentialDto> credentials;
    private Object attributes = new Object();
    private String firstName; //optional
    private String lastName; //optional
    private String username;
    private String email;
}
