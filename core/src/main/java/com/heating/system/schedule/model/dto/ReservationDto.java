package com.heating.system.schedule.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ReservationDto {
    private String name;
    private ZonedDateTime dateFrom;
    private ZonedDateTime dateTo;
    private UUID userId;
}
