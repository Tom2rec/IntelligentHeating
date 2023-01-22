package com.heating.system.infrastructure.web.controller;

import com.heating.system.infrastructure.model.response.AllBuildingsResponse;
import com.heating.system.infrastructure.model.response.AllFacultiesResponse;
import com.heating.system.infrastructure.model.response.AllRoomsResponse;
import com.heating.system.infrastructure.model.response.DetailedBuildingResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

interface InfrastructureEndpoints {

    @GetMapping("all")
    @ApiResponse(description = "Returns all faculties - its id and name")
    ResponseEntity<AllFacultiesResponse> getAllFaculties();

    @GetMapping("faculty/{facultyId}/building/all")
    @ApiResponse(description = "Returns all buildings of given faculty")
    ResponseEntity<AllBuildingsResponse> getAllBuildings(@PathVariable("facultyId") UUID facultyId);

    @GetMapping("building/{buildingId}")
    @ApiResponse(description = "Returns detailed building object")
    ResponseEntity<DetailedBuildingResponse> getDetailedBuildingById(@PathVariable("buildingId") UUID buildingId);

    @GetMapping("building/{buildingId}/room/all")
    @ApiResponse(description = "Returns all rooms of given building")
    ResponseEntity<AllRoomsResponse> getAllRoomsByBuildingId(@PathVariable("buildingId") UUID buildingId);
}
