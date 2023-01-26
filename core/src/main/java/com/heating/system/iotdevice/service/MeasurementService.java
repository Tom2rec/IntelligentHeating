package com.heating.system.iotdevice.service;

import com.heating.system.commons.exception.PlantNotFoundException;
import com.heating.system.iotdevice.mapper.MeasurementMapper;
import com.heating.system.iotdevice.model.Measurement;
import com.heating.system.iotdevice.model.dto.MeasurementDto;
import com.heating.system.iotdevice.model.request.AddNewMeasurementsRequest;
import com.heating.system.iotdevice.repository.MeasurementRepository;
import com.heating.system.iotdevice.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MeasurementService {
    private final PlantRepository plantRepository;
    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    public void addNewMeasurements(String sensorName, AddNewMeasurementsRequest request) {
        var plant = plantRepository.getPlantBySensorName(sensorName)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found!"));
        var measurements = calculateAndAppendTimestamps(request.getMeasurements(), request.getInterval());
        plant.getMeasurements().addAll(
                measurements.stream()
                        .map(measurementDto -> {
                            var measurementEntity = measurementMapper.mapToEntity(measurementDto);
                            measurementEntity.setPlant(plant);
                            return measurementEntity;
                        })
                        .toList()
        );
        plantRepository.save(plant);
    }

    private List<MeasurementDto> calculateAndAppendTimestamps(List<MeasurementDto> measurements, Integer interval) {
        var now = ZonedDateTime.now();
        var counter = 0;
        for(var measurement: measurements) {
            measurement.setTimestamp(now.minus((long) counter * interval, ChronoUnit.SECONDS));
            ++counter;
        }
        return measurements;
    }

    public List<MeasurementDto> getAllMeasurements(Long plantId, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        List<Measurement> measurements;
        if(dateFrom == null && dateTo == null) {
            measurements = measurementRepository.findTop15ByPlant_IdOrderByTimestampDesc(plantId);
        } else {
            measurements = measurementRepository.findAllByPlantIdAndDateBetween(plantId, dateFrom, dateTo);
        }

        return measurements.stream()
                .map(measurementMapper::mapToMeasurementDto)
                .toList();
    }
}
