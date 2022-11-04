package com.heating.system.schedule.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class ScheduleRoomRequest {
    private String cron;
    private ZonedDateTime dateFrom;
    private ZonedDateTime dateTo;
    private Integer durationInMinutes;
}
