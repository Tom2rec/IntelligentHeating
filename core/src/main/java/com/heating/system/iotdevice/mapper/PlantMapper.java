package com.heating.system.iotdevice.mapper;

import com.heating.system.iotdevice.model.Plant;
import com.heating.system.iotdevice.model.dto.PlantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlantMapper {

    @Mapping(target = "userId", source = "plant.user.id")
    PlantDto mapPlantToDto(Plant plant);
}
