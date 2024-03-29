package com.heating.system.infrastructure.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class RoomDto {
    private UUID roomId;
    private String description;
}
