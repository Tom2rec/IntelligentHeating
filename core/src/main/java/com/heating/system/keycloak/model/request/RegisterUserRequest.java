package com.heating.system.keycloak.model.request;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class RegisterUserRequest {

    @Email(message = "Email form is incorrect")
    @NotBlank(message = "Email is required")
    private String email;

    @Size(min = 8, message = "Password should has at least 8 characters")
    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

}
