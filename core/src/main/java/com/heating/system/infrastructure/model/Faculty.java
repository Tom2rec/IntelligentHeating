package com.heating.system.infrastructure.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "faculty", schema = "heatingsystem")
public class Faculty extends BaseUUIDEntity implements Serializable {

    private String name;

    @OneToMany
    @JoinColumn(name = "building_id", referencedColumnName = "id")
    @JsonIgnore
    private List<Building> buildings;
}
