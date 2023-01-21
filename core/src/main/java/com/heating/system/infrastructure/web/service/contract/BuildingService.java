package com.heating.system.infrastructure.web.service.contract;

import com.heating.system.infrastructure.model.dto.BuildingDto;
import com.heating.system.infrastructure.model.dto.DetailedBuildingDto;

import java.util.List;
import java.util.UUID;

public interface BuildingService {

    List<BuildingDto> getAllBuildings(UUID facultyId);

    DetailedBuildingDto getDetailedBuildingDto(UUID buildingId);
}
