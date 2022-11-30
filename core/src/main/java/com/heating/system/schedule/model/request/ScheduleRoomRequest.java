package com.heating.system.schedule.model.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleRoomRequest {

    private String cron;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private Integer durationInMinutes;
}
