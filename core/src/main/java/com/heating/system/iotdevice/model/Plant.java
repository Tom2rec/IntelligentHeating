package com.heating.system.iotdevice.model;

import com.heating.system.commons.jpa.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plant", schema = "heatingsystem")
public class Plant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String familiarName;
    private String sensorName;
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;
    private BigDecimal minHumidity;
    private BigDecimal maxHumidity;

    @ManyToOne(fetch = FetchType.LAZY)
    private IoTUser user;
}
