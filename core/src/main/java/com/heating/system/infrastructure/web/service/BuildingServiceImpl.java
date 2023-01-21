package com.heating.system.infrastructure.web.service;

import com.heating.system.commons.exception.BuildingNotFoundException;
import com.heating.system.commons.json.JsonSerializer;
import com.heating.system.infrastructure.mapper.BuildingMapper;
import com.heating.system.infrastructure.mapper.FloorMapper;
import com.heating.system.infrastructure.mapper.RoomMapper;
import com.heating.system.infrastructure.model.dto.BuildingDto;
import com.heating.system.infrastructure.model.dto.DetailedBuildingDto;
import com.heating.system.infrastructure.repository.BuildingRepository;
import com.heating.system.infrastructure.web.service.contract.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;
    private final BuildingMapper buildingMapper;
    private final FloorMapper floorMapper;
    private final RoomMapper roomMapper;

    @Override
    public List<BuildingDto> getAllBuildings(UUID facultyId) {
        return buildingRepository.getBuildingsByFaculty_Id(facultyId).stream()
                .map(buildingMapper::mapBuildingToDto)
                .toList();
    }

    @Override
    public DetailedBuildingDto getDetailedBuildingDto(UUID buildingId) {
        var building = buildingRepository.getBuildingById(buildingId)
                .orElseThrow(() -> new BuildingNotFoundException("Building Not Found!"));
        var floorsDto = building.getFloors().stream()
                .map(floor -> {
                    var path = floor.getFloorJsonPath();
                    var walls = JsonSerializer.deserializeBuildingWalls(JsonSerializer.readJsonFromFile(path));
                    return floorMapper.mapFloorToDto(floor, walls);
                })
                .toList();
        var roomsDto = building.getRooms().stream()
                .map(room -> {
                    var path = room.getRoomJsonPath();
                    var walls = JsonSerializer.deserializeRoomWalls(JsonSerializer.readJsonFromFile(path));
                    return roomMapper.mapRoomToDto(room, walls);
                })
                .toList();
        return buildingMapper.mapBuildingToDetailedDto(building, floorsDto, roomsDto);
    }
}
