package com.heating.system.infrastructure.model.response;

import com.heating.system.infrastructure.model.dto.DetailedBuildingDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DetailedBuildingResponse {
    private DetailedBuildingDto building;


}
