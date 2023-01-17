package com.heating.system.infrastructure.web.controller.room.temperature;

import com.heating.system.infrastructure.web.controller.room.temperature.response.RoomAllTemperatureInfo;
import com.heating.system.infrastructure.web.controller.room.temperature.service.contract.RoomTemperatureInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.util.UUID;

@CrossOrigin
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomTemperatureInfoController implements RoomTemperatureInfoEndpoints {

    private final RoomTemperatureInfoService roomTemperatureInfoService;

    @Override
    public ResponseEntity<RoomAllTemperatureInfo> getTemperatureInfoForRoom(UUID id, LocalDateTime from,
            LocalDateTime to) {
        return roomTemperatureInfoService.getRoomTemperatureInfoForPeriod(id, from, to);
    }
}
