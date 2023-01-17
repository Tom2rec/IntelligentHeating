package com.heating.system.schedule.web.controller;

import com.heating.system.schedule.model.request.ScheduleRoomRequest;
import com.heating.system.schedule.model.response.ScheduleRoomInfoResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ScheduleController implements ScheduleEndpoints{

    @Override
    public ResponseEntity<ScheduleRoomInfoResponse> getDailyScheduleRoomInfo(UUID roomId, LocalDateTime dateFrom,
            LocalDateTime dateTo) {
        return null;
    }

    @Override
    public ResponseEntity<Void> scheduleRoom(UUID roomId, ScheduleRoomRequest scheduleRoomRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> scheduleRoomByAdmin(UUID roomId, ScheduleRoomRequest scheduleRoomRequest) {
        return null;
    }
}
