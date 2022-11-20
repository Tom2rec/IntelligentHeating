package com.heating.system.keycloak.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponse {
    private String accessToken;
    private String refreshToken;
    private String tokenType;
}
