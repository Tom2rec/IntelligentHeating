package com.heating.system.infrastructure.model.building.temperature.repository;

import com.heating.system.infrastructure.model.building.temperature.model.RoomTemperatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BuildingTemperatureInfoRepository extends JpaRepository<RoomTemperatureInfo, UUID> {
}
