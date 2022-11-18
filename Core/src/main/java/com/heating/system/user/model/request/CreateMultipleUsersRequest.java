package com.heating.system.user.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMultipleUsersRequest {
    List<CreateUserRequest> userCreateRequest;
}
