package com.heating.system.iotdevice.model;

import com.heating.system.commons.jpa.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    private Integer pushIntervalInMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    private IoTUser user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "plant")
    private List<Measurement> measurements = new ArrayList<>();
}
