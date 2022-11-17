package com.heating.system.user.web.controller;

import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserCreateRequest;
import com.heating.system.user.model.response.UserInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@RequestMapping(path = "/user")
public interface UserEndpoints {

    @PostMapping("register/single")
    ResponseEntity<Void> registerSingleUser(UserCreateRequest userCreateRequest);

    @PostMapping("/register/multiple")
    ResponseEntity<Void> registerMultipleUsers(List<UserCreateRequest> userCreateRequest);

    @PostMapping("/login")
    ResponseEntity<Void> login(LoginRequest loginRequest);

    @GetMapping("/{id}")
    ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable("id") UUID id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") UUID id);
}
