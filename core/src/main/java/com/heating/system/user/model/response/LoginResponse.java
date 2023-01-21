package com.heating.system.user.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LoginResponse {
    private UUID userId;
    private String accessToken;
    private Integer expiresIn;
    private Integer refreshExpiresIn;
    private String refreshToken;
    private String tokenType;
    private String sessionState;
}
