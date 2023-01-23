package com.heating.system.iotdevice.model.response;

import com.heating.system.iotdevice.model.dto.IoTUserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IoTUserInfoResponse {
    private IoTUserDto userDto;
}
