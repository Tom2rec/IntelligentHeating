package com.heating.system.schedule.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
public class ScheduleRoomRequest {
    @NotNull
    private UUID userId;
    @FutureOrPresent
    private ZonedDateTime dateFrom;
    @FutureOrPresent
    private ZonedDateTime dateTo;
}
