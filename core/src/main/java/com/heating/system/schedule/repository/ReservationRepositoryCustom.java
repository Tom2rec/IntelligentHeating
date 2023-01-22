package com.heating.system.schedule.repository;

import com.heating.system.schedule.model.Reservation;
import com.heating.system.schedule.model.enumeration.ReservationStatus;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public interface ReservationRepositoryCustom {
    List<Reservation> getReservationsByRoomIdAndDatesAndReservationStatus(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, ReservationStatus status);
    List<Reservation> getReservationsByRoomIdAndDatesAndUserId(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, UUID userId);
    List<Reservation> getReservationForValidation(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
