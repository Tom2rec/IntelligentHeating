package com.heating.system.schedule.web.controller;

import com.heating.system.schedule.model.request.ScheduleRoomRequest;
import com.heating.system.schedule.model.response.AllRoomInfoResponse;
import com.heating.system.schedule.model.response.RoomInfoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.ZonedDateTime;
import java.util.UUID;

@RequestMapping(path = "schedule")
public interface ScheduleEndpoints {

    @GetMapping("room/{id}")
    ResponseEntity<RoomInfoResponse> getDailyRoomInfo(@PathVariable("id") UUID roomId, @RequestParam("dateTime") ZonedDateTime zonedDateTime);

    @GetMapping("room")
    ResponseEntity<AllRoomInfoResponse> getDailyAllRoomInfo(@RequestParam("dateTime") ZonedDateTime zonedDateTime);

    @PostMapping("room/{id}")
    ResponseEntity<Void> scheduleRoom(@PathVariable("id") UUID roomId, @RequestBody ScheduleRoomRequest scheduleRoomRequest);
}
