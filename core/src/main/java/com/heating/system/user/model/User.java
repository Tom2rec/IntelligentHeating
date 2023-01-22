package com.heating.system.user.model;


import com.heating.system.commons.jpa.BaseEntity;
import com.heating.system.schedule.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "heatingsystem")
public class User extends BaseEntity {

    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Reservation> reservations = new ArrayList<>();
}
