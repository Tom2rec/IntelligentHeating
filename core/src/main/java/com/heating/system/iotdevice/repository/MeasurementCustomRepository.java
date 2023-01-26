package com.heating.system.iotdevice.repository;

import com.heating.system.iotdevice.model.Measurement;

import java.time.ZonedDateTime;
import java.util.List;

public interface MeasurementCustomRepository {
    List<Measurement> findAllByPlantIdAndDateBetween(Long plantId, ZonedDateTime dateFrom, ZonedDateTime dateTo);
}
