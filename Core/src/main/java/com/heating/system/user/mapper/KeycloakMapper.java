package com.heating.system.user.mapper;

import com.heating.system.keycloak.model.response.KeycloakLoginResponse;
import com.heating.system.user.model.response.LoginResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KeycloakMapper {

    LoginResponse mapToLoginResponse(KeycloakLoginResponse keycloakLoginResponse);
}
