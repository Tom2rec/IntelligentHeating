package com.heating.system.iotdevice.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeasurementDto {
    private BigDecimal temperature;
    private Integer humidity;
    private LocalDateTime timestamp;
}
