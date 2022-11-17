package com.heating.system.building.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class FacultyDto {
    private UUID facultyId;
    private List<BuildingDto> buildings;
}
