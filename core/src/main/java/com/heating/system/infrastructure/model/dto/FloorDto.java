package com.heating.system.infrastructure.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FloorDto {
    private Integer floorNumber;
    private List<List<List<Float>>> walls;
}
