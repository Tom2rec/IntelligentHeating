package com.heating.system.infrastructure.web.controller;

import com.heating.system.infrastructure.model.response.AllBuildingsResponse;
import com.heating.system.infrastructure.model.response.AllFacultiesResponse;
import com.heating.system.infrastructure.model.response.AllRoomsResponse;
import com.heating.system.infrastructure.model.response.DetailedBuildingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

interface InfrastructureEndpoints {

    @GetMapping("all")
    ResponseEntity<AllFacultiesResponse> getAllFaculties();

    @GetMapping("faculty/{facultyId}/building/all")
    ResponseEntity<AllBuildingsResponse> getAllBuildings(@PathVariable("facultyId") UUID facultyId);

    @GetMapping("building/{buildingId}")
    ResponseEntity<DetailedBuildingResponse> getBuildingById(@PathVariable("buildingId") UUID buildingId);

    @GetMapping("faculty/{facultyId}/building/{buildingId}/rooms") // zwróce wszystkie id roomow
    ResponseEntity<AllRoomsResponse> getAllRoomsForBuilding(@PathVariable("facultyId") UUID facultyId,
                                                            @PathVariable("buildingId") UUID buildingId);

}
