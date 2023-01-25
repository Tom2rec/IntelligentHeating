package com.heating.system.iotdevice.controller;

import com.heating.system.iotdevice.model.request.AddNewMeasurementsRequest;
import com.heating.system.iotdevice.model.response.AllMeasurementsResponse;
import com.heating.system.iotdevice.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;

    @PostMapping("/plant/{sensorName}")
    ResponseEntity<Void> addNewMeasurements(@PathVariable("sensorName") String sensorName,
                                            @RequestBody AddNewMeasurementsRequest request) {
        measurementService.addNewMeasurements(sensorName, request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/plant/{plantId}")
    ResponseEntity<AllMeasurementsResponse> getAllMeasurements(@PathVariable("plantId") Long plantId,
                                                               @RequestParam(required = false) LocalDateTime dateFrom,
                                                               @RequestParam(required = false) LocalDateTime dateTo) {
        var response = measurementService.getAllMeasurements(plantId, dateFrom, dateTo);
        return ResponseEntity.ok(new AllMeasurementsResponse(response));
    }
}
