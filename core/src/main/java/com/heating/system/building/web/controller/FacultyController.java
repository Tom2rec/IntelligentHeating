package com.heating.system.building.web.controller;

import com.heating.system.building.model.response.AllBuildingsResponse;
import com.heating.system.building.model.response.AllFacultiesResponse;
import com.heating.system.building.model.response.AllRoomsResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class FacultyController implements FacultyEndpoints{
    @Override
    public ResponseEntity<AllFacultiesResponse> getAllFaculties() {
        return null;
    }

    @Override
    public ResponseEntity<AllBuildingsResponse> getAllBuildings(UUID facultyId) {
        return null;
    }

    @Override
    public ResponseEntity<AllRoomsResponse> getAllRoomsForBuilding(UUID facultyId, UUID buildingId) {
        return null;
    }
}
