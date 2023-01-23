package com.heating.system.iotdevice.model.response;

import com.heating.system.iotdevice.model.dto.PlantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddNewPlantResponse {
    private PlantDto plant;
}
