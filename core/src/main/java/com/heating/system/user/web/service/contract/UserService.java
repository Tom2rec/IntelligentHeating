package com.heating.system.user.web.service.contract;

import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UpdateUserRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;

import java.util.UUID;

public interface UserService {

    void registerSingleUser(CreateUserRequest userCreateRequest);
    void registerMultipleUsers(CreateMultipleUsersRequest createMultipleUsersRequest);

    LoginResponse login(LoginRequest loginRequest);

    UserInfoResponse update(UUID id, UpdateUserRequest userUpdateRequest);

    UserInfoResponse getUserInfo(UUID id);
}
