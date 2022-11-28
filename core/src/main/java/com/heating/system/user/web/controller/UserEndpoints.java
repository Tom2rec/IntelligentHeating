package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UpdateUserRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(path = "/user")
public interface UserEndpoints {

    @PostMapping("register/single")
    ResponseEntity<Void> registerSingleUser(@RequestBody CreateUserRequest userCreateRequest);

    @PostMapping("/register/multiple")
    ResponseEntity<Void> registerMultipleUsers(@RequestBody CreateMultipleUsersRequest createMultipleUsersRequest);

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest);

    @PutMapping("/update/{id}")
    ResponseEntity<UserInfoResponse> updateUser(@PathVariable("id") UUID id, @RequestBody UpdateUserRequest updateUserRequest);

    @GetMapping("/{id}")
    ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id);
}
