package com.heating.system.infrastructure.model.room.temperature.repository;

import com.heating.system.infrastructure.model.room.temperature.model.RoomTemperatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface RoomTemperatureInfoRepository extends JpaRepository<RoomTemperatureInfo, UUID> {

    List<RoomTemperatureInfo> findByRoomIdAndCreationDateBetween(UUID id, LocalDateTime from,
            LocalDateTime to);

}
