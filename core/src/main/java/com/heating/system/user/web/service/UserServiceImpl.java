package com.heating.system.user.web.service;

import com.heating.system.user.model.dto.UserDto;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserCreateRequest;
import com.heating.system.user.model.request.UserUpdateRequest;
import com.heating.system.user.web.service.contract.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void registerSingleUser(UserCreateRequest userCreateRequest) {

    }

    @Override
    public void registerMultipleUsers(List<UserCreateRequest> userCreateRequest) {

    }

    @Override
    public void login(LoginRequest loginRequest) {

    }

    @Override
    public UserDto update(UserUpdateRequest userUpdateRequest) {
        return null;
    }

    @Override
    public UserDto getUserInfo(UUID id) {
        return null;
    }
}
