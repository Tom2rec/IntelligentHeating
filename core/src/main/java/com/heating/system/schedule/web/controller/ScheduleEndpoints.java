package com.heating.system.schedule.web.controller;

import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.schedule.model.request.ScheduleRoomRequest;
import com.heating.system.schedule.model.response.ScheduleRoomInfoResponse;
import com.heating.system.schedule.model.response.SingleReservationResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@RequestMapping(path = "schedule")
public interface ScheduleEndpoints {

    @GetMapping("room/{roomId}")
    ResponseEntity<ScheduleRoomInfoResponse> getScheduleRoomInfo(
            @PathVariable("roomId") UUID roomId,
            @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTo,
            @RequestParam(name = "status", required = false)ReservationStatus status
            );

    @GetMapping("room/{roomId}/user")
    ResponseEntity<ScheduleRoomInfoResponse> getScheduleRoomInfoForGivenUser(
            @PathVariable("roomId") UUID roomId,
            @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateFrom,
            @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime dateTo,
            @RequestParam("userId") UUID userId
    );

    @PostMapping("room/{roomId}")
    @ApiResponse(description = "Request to the admin to reserve room")
    ResponseEntity<SingleReservationResponse> scheduleRoom(@PathVariable("roomId") UUID roomId,
                                                           @RequestBody ScheduleRoomRequest scheduleRoomRequest);

    @PostMapping("{reservationId}/accept")
    @ApiResponse(description = "Accept reservation")
    ResponseEntity<SingleReservationResponse> acceptReservation(@PathVariable("reservationId") UUID reservationId);

    @PostMapping("{reservationId}/reject")
    @ApiResponse(description = "Accept reservation")
    ResponseEntity<SingleReservationResponse> rejectReservation(@PathVariable("reservationId") UUID reservationId);

    @DeleteMapping("{reservationId}/delete")
    @ApiResponse(description = "Delete reservation")
    ResponseEntity<SingleReservationResponse> deleteReservation(@PathVariable("reservationId") UUID reservationId);
}
