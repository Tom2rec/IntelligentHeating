package com.heating.system.infrastructure.mapper;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.infrastructure.model.dto.BuildingDto;
import com.heating.system.infrastructure.model.dto.DetailedBuildingDto;
import com.heating.system.infrastructure.model.dto.DetailedRoomDto;
import com.heating.system.infrastructure.model.dto.FloorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    @Mapping(target = "buildingId", source = "id")
    BuildingDto mapBuildingToDto(Building building);
    @Mapping(target = "buildingId", source = "building.id")
    @Mapping(target = "floors", source = "floors")
    @Mapping(target = "rooms", source = "rooms")
    DetailedBuildingDto mapBuildingToDetailedDto(Building building, List<FloorDto> floors, List<DetailedRoomDto> rooms);
}
