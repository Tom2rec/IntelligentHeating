package com.heating.system.infrastructure.web.controller.room.temperature.service.contract;

import com.heating.system.infrastructure.web.controller.room.temperature.response.RoomAllTemperatureInfo;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public interface RoomTemperatureInfoService {

    ResponseEntity<RoomAllTemperatureInfo> getRoomTemperatureInfoForPeriod(UUID id, LocalDateTime from,
            LocalDateTime to);
}
