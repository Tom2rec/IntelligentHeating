package com.heating.system.user.model.response;

import com.heating.system.user.model.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponse {
    private UserDto userDto;
}
