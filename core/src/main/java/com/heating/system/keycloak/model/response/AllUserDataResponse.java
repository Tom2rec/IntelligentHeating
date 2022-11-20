package com.heating.system.keycloak.model.response;

import com.heating.system.keycloak.model.dto.UserDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AllUserDataResponse {
    private Set<UserDataDto> users;
}
