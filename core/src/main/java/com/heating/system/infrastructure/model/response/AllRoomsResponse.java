package com.heating.system.infrastructure.model.response;

import com.heating.system.infrastructure.model.dto.RoomDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AllRoomsResponse {
    private List<RoomDto> rooms;
}
