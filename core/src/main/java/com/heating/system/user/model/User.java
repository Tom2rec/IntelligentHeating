package com.heating.system.user.model;


import com.heating.system.commons.jpa.BaseUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user", schema = "heatingsystem")
public class User extends BaseUUIDEntity {

    private String keycloakUserId;

    private String firstName;

    private String lastName;

    private String email;
}
