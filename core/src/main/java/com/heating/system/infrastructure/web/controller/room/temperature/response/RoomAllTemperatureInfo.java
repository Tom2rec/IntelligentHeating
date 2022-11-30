package com.heating.system.infrastructure.web.controller.room.temperature.response;

import com.heating.system.infrastructure.web.controller.room.temperature.dto.RoomTemperatureInfoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RoomAllTemperatureInfo {

    private List<RoomTemperatureInfoDto> allTemperatureInfo;

}
