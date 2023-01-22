package com.heating.system.infrastructure.web.service.contract;

import com.heating.system.infrastructure.model.dto.RoomDto;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    List<RoomDto> getAllRoomsByBuildingId(UUID buildingId);
}
