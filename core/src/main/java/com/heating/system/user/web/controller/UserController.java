package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserCreateRequest;
import com.heating.system.user.model.response.UserInfoResponse;
import com.heating.system.user.web.service.contract.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserController implements UserEndpoints{
    private final UserService userService;

    @Override
    public ResponseEntity<Void> registerSingleUser(UserCreateRequest userCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> registerMultipleUsers(List<UserCreateRequest> userCreateRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UserInfoResponse> getUserInfo(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        return null;
    }
}
