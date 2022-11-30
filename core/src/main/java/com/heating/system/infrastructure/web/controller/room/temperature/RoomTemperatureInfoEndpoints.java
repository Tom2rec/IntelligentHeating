package com.heating.system.infrastructure.web.controller.room.temperature;

import com.heating.system.infrastructure.web.controller.room.temperature.response.RoomAllTemperatureInfo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.UUID;

@RequestMapping("room/temperature/info")
public interface RoomTemperatureInfoEndpoints {

    @GetMapping("{id}")
    ResponseEntity<RoomAllTemperatureInfo> getTemperatureInfoForRoom(@PathVariable UUID id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @RequestParam LocalDateTime to);
}
