package com.heating.system.schedule.web.controller;

import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.schedule.model.request.ScheduleRoomRequest;
import com.heating.system.schedule.model.response.ScheduleRoomInfoResponse;
import com.heating.system.schedule.model.response.SingleReservationResponse;
import com.heating.system.schedule.web.service.contract.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class ScheduleController implements ScheduleEndpoints {
    private final ScheduleService scheduleService;

    @Override
    public ResponseEntity<ScheduleRoomInfoResponse> getScheduleRoomInfo(UUID roomId, ZonedDateTime dateFrom,
                                                                        ZonedDateTime dateTo, ReservationStatus status) {
        return ResponseEntity.ok(new ScheduleRoomInfoResponse(scheduleService.getScheduleRoomInfo(roomId, dateFrom, dateTo, status)));
    }

    @Override
    public ResponseEntity<ScheduleRoomInfoResponse> getScheduleRoomInfoForGivenUser(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, UUID userId) {
        return ResponseEntity.ok(new ScheduleRoomInfoResponse(scheduleService.getScheduleRoomInfoForGivenUser(roomId, dateFrom, dateTo, userId)));
    }

    @Override
    public ResponseEntity<SingleReservationResponse> scheduleRoom(UUID roomId, ScheduleRoomRequest scheduleRoomRequest) {
        return ResponseEntity.ok(new SingleReservationResponse(scheduleService.scheduleRoom(roomId, scheduleRoomRequest)));
    }

    @Override
    public ResponseEntity<SingleReservationResponse> acceptReservation(UUID reservationId) {
        return ResponseEntity.ok(new SingleReservationResponse(scheduleService.acceptReservation(reservationId)));
    }

    @Override
    public ResponseEntity<SingleReservationResponse> rejectReservation(UUID reservationId) {
        return ResponseEntity.ok(new SingleReservationResponse(scheduleService.rejectReservation(reservationId)));
    }

    @Override
    public ResponseEntity<SingleReservationResponse> deleteReservation(UUID reservationId) {
        return ResponseEntity.ok(new SingleReservationResponse(scheduleService.deleteReservation(reservationId)));
    }
}
