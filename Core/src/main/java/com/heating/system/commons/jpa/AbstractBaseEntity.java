package com.heating.system.commons.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@SuperBuilder
public abstract class AbstractBaseEntity {

    @Column(name = "creation_date", nullable = false)
    protected ZonedDateTime creationDate;

    @Column(name = "update_date", nullable = false)
    protected ZonedDateTime updateDate;

    @PrePersist
    protected void prePersist() {
        creationDate = ZonedDateTime.now();
        updateDate = ZonedDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        updateDate = ZonedDateTime.now();
    }
}
