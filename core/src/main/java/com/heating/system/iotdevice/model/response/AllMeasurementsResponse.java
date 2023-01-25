package com.heating.system.iotdevice.model.response;

import com.heating.system.iotdevice.model.dto.MeasurementDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AllMeasurementsResponse {
    private List<MeasurementDto> measurements;
}
