package com.heating.system.keycloak.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDto {
    private final String type = "password";
    private String value;
    private final boolean temporary = false;
}
