package com.heating.system.schedule.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ScheduleRoomByAdminRequest extends ScheduleRoomRequest{
    private UUID userId;
}
