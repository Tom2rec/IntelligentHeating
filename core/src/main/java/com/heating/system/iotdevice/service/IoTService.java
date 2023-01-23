package com.heating.system.iotdevice.service;

import com.heating.system.commons.exception.UserNotFoundException;
import com.heating.system.iotdevice.mapper.IoTUserMapper;
import com.heating.system.iotdevice.model.IoTUser;
import com.heating.system.iotdevice.model.request.CreateIoTUserRequest;
import com.heating.system.iotdevice.model.request.IoTLoginRequest;
import com.heating.system.iotdevice.model.response.IoTUserInfoResponse;
import com.heating.system.iotdevice.repository.IoTUserRepository;
import com.heating.system.keycloak.connector.KeycloakConnector;
import com.heating.system.user.mapper.KeycloakMapper;
import com.heating.system.user.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class IoTService {

    private final KeycloakConnector keycloakConnector;
    private final IoTUserRepository ioTUserRepository;
    private final KeycloakMapper keycloakMapper;
    private final IoTUserMapper ioTUserMapper;

    public void registerSingleUser(CreateIoTUserRequest createUserRequest) {
        var loginAdminResponse = keycloakConnector.loginAdmin();
        createAndPersistSingleUser(createUserRequest, loginAdminResponse.getAccessToken());
    }

    public LoginResponse login(IoTLoginRequest loginRequest) {
        var keycloakLoginResponse = keycloakConnector.login(loginRequest.getEmail(), loginRequest.getPassword());
        var loginResponse =  keycloakMapper.mapToLoginResponse(keycloakLoginResponse);
        loginResponse.setUserId(
                ioTUserRepository.getUserByEmail(loginRequest.getEmail())
                        .map(IoTUser::getId)
                        .orElse(null)
        );
        return loginResponse;
    }

    private void createAndPersistSingleUser(CreateIoTUserRequest createUserRequest, String accessToken) {
        var keycloakUserId = keycloakConnector.registerUser(
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                createUserRequest.getFirstName(),
                createUserRequest.getLastName(),
                accessToken
        );

        var ioTUser = IoTUser.builder()
                .id(UUID.fromString(keycloakUserId))
                .firstName(createUserRequest.getFirstName())
                .lastName(createUserRequest.getLastName())
                .email(createUserRequest.getEmail())
                .build();

        ioTUserRepository.save(ioTUser);
    }

    public IoTUserInfoResponse getUserInfo(UUID id) {
        var user = ioTUserRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with UUID: %s not found", id)));
        return new IoTUserInfoResponse(ioTUserMapper.mapToDto(user));
    }

}
