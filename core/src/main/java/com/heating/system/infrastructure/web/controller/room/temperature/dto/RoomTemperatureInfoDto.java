package com.heating.system.infrastructure.web.controller.room.temperature.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomTemperatureInfoDto {

    private UUID roomId;
    private LocalDateTime creationDate;
    private Boolean isRadiatorOn;
    private double temperatureInCelsius;
}
