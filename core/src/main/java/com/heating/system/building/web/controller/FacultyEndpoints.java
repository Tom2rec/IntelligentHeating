package com.heating.system.building.web.controller;

import com.heating.system.building.model.response.AllBuildingsResponse;
import com.heating.system.building.model.response.AllFacultiesResponse;
import com.heating.system.building.model.response.AllRoomsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("faculty")
interface FacultyEndpoints {

    @GetMapping("all")
    ResponseEntity<AllFacultiesResponse> getAllFaculties();

    @GetMapping("{facultyId}/building/all")
    ResponseEntity<AllBuildingsResponse> getAllBuildings(@PathVariable("facultyId") UUID facultyId);

    @GetMapping("{facultyId}/building/{buildingId}/rooms")
    ResponseEntity<AllRoomsResponse> getAllRoomsForBuilding(@PathVariable("facultyId") UUID facultyId,
                                                            @PathVariable("buildingId") UUID buildingId);

}
