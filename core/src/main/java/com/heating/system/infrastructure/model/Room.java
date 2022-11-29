package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.mapstruct.control.DeepClone;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
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

    @JoinColumn(name = "building_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude
    private Building building;

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
