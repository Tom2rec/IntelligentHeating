package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "building", schema = "heatingsystem")
public class Building extends BaseUUIDEntity {

    private String description;

    @OneToMany
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    @JsonManagedReference
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;
}
