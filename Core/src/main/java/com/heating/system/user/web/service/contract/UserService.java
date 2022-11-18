package com.heating.system.user.web.service.contract;

import com.heating.system.user.model.dto.UserDto;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserUpdateRequest;
import com.heating.system.user.model.response.LoginResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void registerSingleUser(CreateUserRequest userCreateRequest);
    void registerMultipleUsers(List<CreateUserRequest> userCreateRequest);

    LoginResponse login(LoginRequest loginRequest);

    UserDto update(UserUpdateRequest userUpdateRequest);

    UserDto getUserInfo(UUID id);
}
