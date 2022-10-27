package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserCreateRequest;
import com.heating.system.user.model.request.UserUpdateRequest;
import com.heating.system.user.model.response.UpdateUserResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping(path = "user")
interface UserEndpoints {

    @PostMapping
    ResponseEntity<Void> register(UserCreateRequest userCreateRequest);

    @PostMapping
    ResponseEntity<Void> login(LoginRequest loginRequest);

    @PutMapping
    ResponseEntity<UpdateUserResponse> update(UserUpdateRequest userUpdateRequest);

    @GetMapping
    ResponseEntity<UserInfoResponse> getUserInfo(UUID id);
}
