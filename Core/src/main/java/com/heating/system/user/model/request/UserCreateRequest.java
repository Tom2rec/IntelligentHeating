package com.heating.system.user.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserCreateRequest {
    private String email;
    private String firstName;
    private String lastName;
}
