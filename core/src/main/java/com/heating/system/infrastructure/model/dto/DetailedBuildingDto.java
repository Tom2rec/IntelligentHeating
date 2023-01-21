package com.heating.system.infrastructure.model.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedBuildingDto {
    private UUID buildingId;
    private String description;
    private List<FloorDto> floors;
    private List<RoomDto> rooms;

}
