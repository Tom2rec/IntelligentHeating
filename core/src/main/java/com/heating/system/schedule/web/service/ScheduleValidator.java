package com.heating.system.schedule.web.service;

import com.heating.system.commons.exception.InvalidDatesException;
import com.heating.system.commons.exception.InvalidReservationStatusException;
import com.heating.system.commons.exception.ReservationConflictException;
import com.heating.system.schedule.model.Reservation;
import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.schedule.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class ScheduleValidator {

    private final ReservationRepository reservationRepository;

    public void validateCanAcceptReservation(Reservation reservation) {
        if(!reservation.getReservationStatus().equals(ReservationStatus.PENDING)) {
            throw new InvalidReservationStatusException("Only pending reservations can be accepted!");
        }

        var now = ZonedDateTime.now();
        if(reservation.getDateFrom().isBefore(now)) {
            throw new InvalidDatesException("You can't accept reservation from the past");
        }

        var conflictingReservations = reservationRepository.getReservationForValidation(
                reservation.getRoom().getId(),
                reservation.getDateFrom(),
                reservation.getDateTo()
        );
        if(!conflictingReservations.isEmpty()) {
            throw new ReservationConflictException("Overlapping reservation!");
        }
    }

    public void validateCanRejectReservation(Reservation reservation) {
        if(!reservation.getReservationStatus().equals(ReservationStatus.PENDING)) {
            throw new InvalidReservationStatusException("Only pending reservations can be rejected!");
        }
    }

    public void validateCanDeleteReservation(Reservation reservation) {
        if(!reservation.getReservationStatus().equals(ReservationStatus.ACCEPTED)) {
            throw new InvalidReservationStatusException("Only already accepted reservations can be deleted!");
        }
    }

    public void validateCanSchedule(ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        if(dateFrom.isAfter(dateTo) || dateFrom.isEqual(dateTo)) {
            throw new InvalidDatesException("DateTo must be grater than dateFrom!");
        }

        var now = ZonedDateTime.now();
        if(dateFrom.isBefore(now)) {
            throw new InvalidDatesException("You can't schedule reservation with the past date");
        }
    }
}
