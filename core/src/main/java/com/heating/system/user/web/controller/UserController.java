package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UpdateUserRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import com.heating.system.user.web.service.contract.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@Slf4j
public class UserController implements UserEndpoints{
    private final UserService userService;

    @Override
    public ResponseEntity<Void> registerSingleUser(CreateUserRequest createUserRequest) {
        userService.registerSingleUser(createUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> registerMultipleUsers(CreateMultipleUsersRequest createMultipleUsersRequest) {
        userService.registerMultipleUsers(createMultipleUsersRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        var response = userService.login(loginRequest);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserInfoResponse> updateUser(UUID id, UpdateUserRequest updateUserRequest) {
        var response = userService.update(id, updateUserRequest);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<UserInfoResponse> getUserInfo(UUID id) {
        var response = userService.getUserInfo(id);
        return ResponseEntity.ok(response);
    }
}
