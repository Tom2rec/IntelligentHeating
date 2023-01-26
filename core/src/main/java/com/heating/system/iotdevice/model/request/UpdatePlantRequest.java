package com.heating.system.iotdevice.model.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class UpdatePlantRequest {
    private String location;
    private String familiarName;
    private String sensorName;
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;
    private BigDecimal minHumidity;
    private BigDecimal maxHumidity;
    private Integer pushIntervalInMinutes;
}
