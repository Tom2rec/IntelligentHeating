package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.mapstruct.control.DeepClone;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DeepClone
@Table(name = "room", schema = "heatingsystem")
public class Room extends BaseUUIDEntity implements Serializable {

    // TODO Add syntax validation ex. string in format C2:112
    @NotNull
    private String description;

    @OneToMany
    @JsonIgnore
    private List<Room> neighbourRooms;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Building building;

    private String roomJsonPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Floor floor;

    @Column(name = "connected_wall_width_in_meters")
    private double connectedWallWidthInMeters;

    @Column(name = "not_connected_wall_length_in_meters")
    private double notConnectedWallLengthInMeters;

    @Column(name = "radiation_power_in_watts_per_square_meters")
    private double radiatorPowerInWattsPerSquareMeters;

    @Column(name = "height_in_meters")
    private double heightInMeters;

    /*
     * delta_A
     */
    @Column(name = "thermal_conductivity")
    private double thermalConductivity;

    @Column(name = "wall_thickness")
    private double wallThickness;

    @ElementCollection
    @Transient
    private List<UUID> neighbourRoomIds;

    @Transient
    private double temperatureInCelsius;

    @Transient
    private boolean isRadiatorOn;
}
