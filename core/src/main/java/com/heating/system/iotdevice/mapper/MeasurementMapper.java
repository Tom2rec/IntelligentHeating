package com.heating.system.iotdevice.mapper;

import com.heating.system.iotdevice.model.Measurement;
import com.heating.system.iotdevice.model.dto.MeasurementDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    Measurement mapToEntity(MeasurementDto measurement);

    MeasurementDto mapToMeasurementDto(Measurement measurement);
}
