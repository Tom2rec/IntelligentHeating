package com.heating.system.infrastructure.web.service;

import com.heating.system.infrastructure.mapper.RoomMapper;
import com.heating.system.infrastructure.model.dto.RoomDto;
import com.heating.system.infrastructure.repository.RoomRepository;
import com.heating.system.infrastructure.web.service.contract.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;
    @Override
    public List<RoomDto> getAllRoomsByBuildingId(UUID buildingId) {
        return roomRepository.getRoomsByBuilding_Id(buildingId).stream()
                .map(roomMapper::mapRoomToDto)
                .toList();
    }
}
