package com.heating.system.user.model.request;

import lombok.Getter;

@Getter
public class UpdateUserRequest {
    private String email;
    private String firstName;
    private String lastName;

}
