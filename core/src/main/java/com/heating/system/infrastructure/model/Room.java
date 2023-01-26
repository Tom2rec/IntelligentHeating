package com.heating.system.infrastructure.model;

import com.heating.system.commons.jpa.BaseUUIDEntity;
import com.heating.system.schedule.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room", schema = "heatingsystem")
public class Room extends BaseUUIDEntity implements Serializable {

    @NotNull
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Room> neighbourRooms = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "room")
    private List<Reservation> reservations = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Building building;

    private String roomJsonPath;

    @ManyToOne(fetch = FetchType.EAGER)
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

    private double temperatureInCelsius;

    private boolean isRadiatorOn;
}
