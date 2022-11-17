package com.heating.system.user.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserUpdateRequest {
    private String firstName;
    private String lastName;

}
