package com.heating.system.infrastructure.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class DetailedRoomDto {
    private UUID roomId;
    private String description;
    private Integer floorNumber;
    private List<List<Float>> walls;
}
