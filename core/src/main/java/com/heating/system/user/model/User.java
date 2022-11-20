package com.heating.system.user.model;


import com.heating.system.commons.jpa.AbstractBaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "heatingsystem")
public class User extends AbstractBaseEntity {

    @Id
    private UUID id;

    private String keycloakUserId;

    private String firstName;

    private String lastName;

    private String email;
}
