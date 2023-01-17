package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import com.heating.system.user.web.service.contract.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@CrossOrigin
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
        return null;
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        var response = userService.login(loginRequest);
        return ResponseEntity.ok(response);
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
