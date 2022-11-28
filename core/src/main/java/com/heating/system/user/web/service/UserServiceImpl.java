package com.heating.system.user.web.service;

import com.heating.system.keycloak.connector.KeycloakConnector;
import com.heating.system.user.exception.UserNotFoundException;
import com.heating.system.user.mapper.KeycloakMapper;
import com.heating.system.user.mapper.UserMapper;
import com.heating.system.user.model.User;
import com.heating.system.user.model.request.CreateMultipleUsersRequest;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UpdateUserRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.model.response.UserInfoResponse;
import com.heating.system.user.repository.UserRepository;
import com.heating.system.user.web.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeycloakConnector keycloakConnector;
    private final KeycloakMapper keycloakMapper;

    @Override
    public void registerSingleUser(CreateUserRequest createUserRequest) {
        var loginAdminResponse = keycloakConnector.loginAdmin();
        createAndPersistSingleUser(createUserRequest, loginAdminResponse.getAccessToken());
    }

    @Override
    public void registerMultipleUsers(CreateMultipleUsersRequest createMultipleUsersRequest) {
        var loginAdminResponse = keycloakConnector.loginAdmin();
        createMultipleUsersRequest.getUserCreateRequest()
                .forEach(user -> createAndPersistSingleUser(user, loginAdminResponse.getAccessToken()));
    }

    private void createAndPersistSingleUser(CreateUserRequest createUserRequest, String accessToken) {
        var keycloakUserId = keycloakConnector.registerUser(
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                accessToken
        );

        var user = User.builder()
                .id(UUID.randomUUID())
                .keycloakUserId(keycloakUserId)
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .build();

        userRepository.save(user);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var keycloakLoginResponse = keycloakConnector.login(loginRequest.getEmail(), loginRequest.getPassword());
        return keycloakMapper.mapToLoginResponse(keycloakLoginResponse);
    }

    @Override
    public UserInfoResponse update(UUID id, UpdateUserRequest userUpdateRequest) {
        var user = userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with UUID: %s not found", id)));
        keycloakConnector.updateUser(userUpdateRequest.getEmail(), userUpdateRequest.getFirstName(), userUpdateRequest.getLastName(), user.getKeycloakUserId());
        return null;
    }

    @Override
    public UserInfoResponse getUserInfo(UUID id) {
        var user = userRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with UUID: %s not found", id)));
        return new UserInfoResponse(userMapper.mapToDto(user));
    }
}
