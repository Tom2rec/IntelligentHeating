package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.mapstruct.control.DeepClone;

import javax.persistence.*;
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
@DeepClone
@Table(name = "building", schema = "heatingsystem")
public class Building extends BaseUUIDEntity implements Serializable {

    private String description;
    // dorobic pole Walls - lista arrayek - trzy poziomy zagnieżdżenia!!

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "building")
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "building")
    private List<Floor> floors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;
}
