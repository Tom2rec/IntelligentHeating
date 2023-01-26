package com.heating.system.iotdevice.mapper;

import com.heating.system.iotdevice.model.Measurement;
import com.heating.system.iotdevice.model.dto.MeasurementDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    Measurement mapToEntity(MeasurementDto measurement);

    @Mapping(target = "timestamp", source = "measurement.timestamp", qualifiedByName = "addZone")
    MeasurementDto mapToMeasurementDto(Measurement measurement);

    @Named("addZone")
    default ZonedDateTime addZone(ZonedDateTime date) {
        return date.withZoneSameInstant(ZoneId.of("UTC"));
    }
}
