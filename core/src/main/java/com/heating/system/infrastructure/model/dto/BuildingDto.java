package com.heating.system.infrastructure.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BuildingDto {
    private UUID buildingId;
    private String description;
}
