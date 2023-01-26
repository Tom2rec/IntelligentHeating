package com.heating.system.iotdevice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "measurement", schema = "heatingsystem")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ZonedDateTime timestamp;
    private BigDecimal temperature;
    private Integer humidity;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plant plant;
}
