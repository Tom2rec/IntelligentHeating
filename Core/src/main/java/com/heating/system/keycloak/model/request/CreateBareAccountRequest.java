package com.heating.system.keycloak.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBareAccountRequest {
    @Email(message = "Email form is incorrect")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotEmpty
    private List<String> roles;

    @NotEmpty
    private List<String> requiredActions;
}
