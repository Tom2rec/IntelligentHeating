package com.heating.system.keycloak.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateUserRequest {
    private String email;
    private String firstName;
    private String lastName;
}
