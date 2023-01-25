package com.heating.system.iotdevice.repository;

import com.heating.system.iotdevice.model.Measurement;

import java.time.LocalDateTime;
import java.util.List;

public interface MeasurementCustomRepository {
    List<Measurement> findAllByPlantIdAndDateBetween(Long plantId, LocalDateTime dateFrom, LocalDateTime dateTo);
}
