package com.heating.system.infrastructure.mapper;

import com.heating.system.infrastructure.model.Room;
import com.heating.system.infrastructure.model.dto.RoomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    @Mapping(target = "roomId", source = "room.id")
    @Mapping(target = "walls", source = "walls")
    @Mapping(target = "floorNumber", source = "room.floor.floorNumber")
    RoomDto mapRoomToDto(Room room, List<List<Float>> walls);
}
