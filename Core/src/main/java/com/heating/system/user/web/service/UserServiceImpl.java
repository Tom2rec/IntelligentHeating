package com.heating.system.user.web.service;

import com.heating.system.keycloak.connector.KeycloakConnector;
import com.heating.system.user.mapper.KeycloakMapper;
import com.heating.system.user.model.User;
import com.heating.system.user.model.dto.UserDto;
import com.heating.system.user.model.request.CreateUserRequest;
import com.heating.system.user.model.request.LoginRequest;
import com.heating.system.user.model.request.UserUpdateRequest;
import com.heating.system.user.model.response.LoginResponse;
import com.heating.system.user.repository.UserRepository;
import com.heating.system.user.web.service.contract.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final KeycloakConnector keycloakConnector;
    private final KeycloakMapper keycloakMapper;

    @Override
    public void registerSingleUser(CreateUserRequest createUserRequest) {
        var keycloakUserId = keycloakConnector.registerUser(
            createUserRequest.getEmail(),
            createUserRequest.getPassword(),
            createUserRequest.getFirstName(),
            createUserRequest.getLastName()
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
    public void registerMultipleUsers(List<CreateUserRequest> userCreateRequest) {

    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        var keycloakLoginResponse = keycloakConnector.login(loginRequest.getEmail(), loginRequest.getPassword());
        return keycloakMapper.mapToLoginResponse(keycloakLoginResponse);
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
