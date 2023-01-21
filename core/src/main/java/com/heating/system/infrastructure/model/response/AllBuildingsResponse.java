package com.heating.system.infrastructure.model.response;

import com.heating.system.infrastructure.model.dto.BuildingDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllBuildingsResponse {
    private List<BuildingDto> buildings;
}
