package com.heating.system.schedule.model.dto;

import com.heating.system.schedule.model.enumeration.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private UUID reservationId;
    private ZonedDateTime dateFrom;
    private ZonedDateTime dateTo;
    private ReservationStatus status;
    private String fullName;
    private String email;
}
