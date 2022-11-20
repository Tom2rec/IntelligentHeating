package com.heating.system.building.model.response;

import com.heating.system.building.model.dto.BuildingDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AllBuildingsResponse {
    private List<BuildingDto> buildings;
}
