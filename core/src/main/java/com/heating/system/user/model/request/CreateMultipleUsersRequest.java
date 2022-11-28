package com.heating.system.user.model.request;

import lombok.Getter;

import java.util.List;

@Getter
public class CreateMultipleUsersRequest {
    List<CreateUserRequest> userCreateRequest;
}
