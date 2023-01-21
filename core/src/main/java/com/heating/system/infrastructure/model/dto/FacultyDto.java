package com.heating.system.infrastructure.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class FacultyDto {
    private UUID facultyId;
    private String name;
}
