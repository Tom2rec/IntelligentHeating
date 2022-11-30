package com.heating.system.schedule.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ReservationDto {

    private String name;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private UUID userId;
}
