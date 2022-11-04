package com.heating.system.schedule.model.response;

import com.heating.system.schedule.model.dto.ReservationDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ScheduleRoomInfoResponse {
    private List<ReservationDto> reservations;
}
