package com.heating.system.infrastructure.web.controller;

import com.heating.system.infrastructure.model.response.AllBuildingsResponse;
import com.heating.system.infrastructure.model.response.AllFacultiesResponse;
import com.heating.system.infrastructure.model.response.AllRoomsResponse;
import com.heating.system.infrastructure.model.response.DetailedBuildingResponse;
import com.heating.system.infrastructure.web.service.contract.BuildingService;
import com.heating.system.infrastructure.web.service.contract.FacultyService;
import com.heating.system.infrastructure.web.service.contract.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class InfrastructureController implements InfrastructureEndpoints {

    private final FacultyService facultyService;
    private final BuildingService buildingService;
    private final RoomService roomService;
    @Override
    public ResponseEntity<AllFacultiesResponse> getAllFaculties() {
        return ResponseEntity.ok(new AllFacultiesResponse(facultyService.getAllFaculties()));
    }

    @Override
    public ResponseEntity<AllBuildingsResponse> getAllBuildings(UUID facultyId) {
        return ResponseEntity.ok(new AllBuildingsResponse(buildingService.getAllBuildings(facultyId)));
    }

    @Override
    public ResponseEntity<DetailedBuildingResponse> getBuildingById(UUID buildingId) {
        return ResponseEntity.ok(new DetailedBuildingResponse(buildingService.getDetailedBuildingDto(buildingId)));
    }

    @Override
    public ResponseEntity<AllRoomsResponse> getAllRoomsForBuilding(UUID facultyId, UUID buildingId) {
        return null;
    }
}
