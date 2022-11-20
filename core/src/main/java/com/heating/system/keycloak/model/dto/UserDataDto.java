package com.heating.system.keycloak.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDataDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
