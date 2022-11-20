package com.heating.system.schedule.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ScheduleRoomByAdminRequest extends ScheduleRoomRequest{
    private UUID userId;
}
