package com.heating.system.user.web.service.contract;

import com.heating.system.user.model.dto.UserDto;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserCreateRequest;
import com.heating.system.user.model.request.UserUpdateRequest;

import java.util.UUID;

public interface UserService {

    void register(UserCreateRequest userCreateRequest);

    void login(LoginRequest loginRequest);

    UserDto update(UserUpdateRequest userUpdateRequest);

    UserDto getUserInfo(UUID id);
}
