package com.heating.system.iotdevice.model;

import com.heating.system.commons.jpa.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "iot_user", schema = "heatingsystem")
public class IoTUser extends BaseEntity {

    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user")
    private List<Plant> plants = new ArrayList<>();

}
