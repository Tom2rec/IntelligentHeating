package com.heating.system.schedule.model.response;

import com.heating.system.schedule.model.dto.ReservationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SingleReservationResponse {
    private ReservationDto reservationDto;
}
