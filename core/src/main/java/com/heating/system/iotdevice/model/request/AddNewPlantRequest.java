package com.heating.system.iotdevice.model.request;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class AddNewPlantRequest {
    @NotNull
    private String location;
    @NotNull
    private String familiarName;
    @NotNull
    private String sensorName;
    @NotNull
    private BigDecimal minTemperature;
    @NotNull
    private BigDecimal maxTemperature;
    @NotNull
    private BigDecimal minHumidity;
    @NotNull
    private BigDecimal maxHumidity;
    private Integer pushIntervalInMinutes;
}
