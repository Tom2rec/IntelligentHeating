package com.heating.system.schedule.web.service.contract;

import com.heating.system.schedule.model.dto.ReservationDto;
import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.schedule.model.request.ScheduleRoomRequest;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface ScheduleService {
    List<ReservationDto> getScheduleRoomInfo(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, ReservationStatus status);
    List<ReservationDto> getScheduleRoomInfoForGivenUser(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, UUID userId);
    ReservationDto scheduleRoom(UUID roomId, ScheduleRoomRequest request);
    ReservationDto acceptReservation(UUID reservationId);
    ReservationDto rejectReservation(UUID reservationId);
    ReservationDto deleteReservation(UUID reservationId);
}
