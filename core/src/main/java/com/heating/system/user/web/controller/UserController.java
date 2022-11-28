package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UpdateUserRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import com.heating.system.user.web.service.contract.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
public class UserController implements UserEndpoints{
    private final UserService userService;

    @Override
    public ResponseEntity<Void> registerSingleUser(CreateUserRequest createUserRequest) {
        userService.registerSingleUser(createUserRequest);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> registerMultipleUsers(CreateMultipleUsersRequest createMultipleUsersRequest) {
        userService.registerMultipleUsers(createMultipleUsersRequest);
        return ResponseEntity.noContent().build();
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

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        return null;
    }
}
