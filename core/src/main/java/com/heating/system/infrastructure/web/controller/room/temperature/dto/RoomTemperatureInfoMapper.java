package com.heating.system.infrastructure.web.controller.room.temperature.dto;

import com.heating.system.infrastructure.model.room.temperature.model.RoomTemperatureInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoomTemperatureInfoMapper {

    RoomTemperatureInfoMapper INSTANCE = Mappers.getMapper(RoomTemperatureInfoMapper.class);

    RoomTemperatureInfoDto toDto(RoomTemperatureInfo roomTemperatureInfo);
}
