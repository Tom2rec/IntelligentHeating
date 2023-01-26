package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "building", schema = "heatingsystem")
public class Building extends BaseUUIDEntity implements Serializable {

    private String description;
    // dorobic pole Walls - lista arrayek - trzy poziomy zagnieżdżenia!!

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "building", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "building")
    private List<Floor> floors = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Faculty faculty;

}
