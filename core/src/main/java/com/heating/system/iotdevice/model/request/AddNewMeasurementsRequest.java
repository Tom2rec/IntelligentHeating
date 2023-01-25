package com.heating.system.iotdevice.model.request;

import com.heating.system.iotdevice.model.dto.MeasurementDto;
import lombok.Getter;

import java.util.List;

@Getter
public class AddNewMeasurementsRequest {
    private List<MeasurementDto> measurements;
    private Integer interval; // seconds of deep sleep mode
}
