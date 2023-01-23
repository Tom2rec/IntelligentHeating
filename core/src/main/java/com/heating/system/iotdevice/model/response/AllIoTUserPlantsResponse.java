package com.heating.system.iotdevice.model.response;

import com.heating.system.iotdevice.model.dto.PlantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllIoTUserPlantsResponse {
    private List<PlantDto> plants;
}
