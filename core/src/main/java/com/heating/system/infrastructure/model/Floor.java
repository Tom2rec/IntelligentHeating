package com.heating.system.infrastructure.model;

import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "floor", schema = "heatingsystem")
public class Floor extends BaseUUIDEntity {

    private Integer floorNumber;

    private String floorJsonPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "floor")
    private List<Room> rooms = new ArrayList<>();
}
