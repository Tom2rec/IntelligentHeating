package com.heating.system.keycloak.model.response;

import com.heating.system.keycloak.model.dto.UserDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDataResponse {
    private UserDataDto userDataDto;
}
