package com.heating.system.infrastructure.mapper;

import com.heating.system.infrastructure.model.Floor;
import com.heating.system.infrastructure.model.dto.FloorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FloorMapper {
    FloorDto mapFloorToDto(Floor floor, List<List<List<Float>>> walls);
}
