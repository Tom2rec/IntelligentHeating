package com.heating.system.infrastructure.model.room.temperature.model;

import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room_temperature_info", schema = "heatingsystem")
public class RoomTemperatureInfo extends BaseUUIDEntity {

    @Column(name = "room_id")
    private UUID roomId;

    @Column(name = "is_radiator_on")
    private Boolean isRadiatorOn;

    @Column(name = "temperature_in_celsius")
    private double temperatureInCelsius;
}
