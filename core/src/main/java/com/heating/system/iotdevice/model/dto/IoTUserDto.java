package com.heating.system.iotdevice.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class IoTUserDto {
    private UUID id;
    private String fullName;
    private String email;
}
