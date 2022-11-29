package com.heating.system.commons.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;

@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
@SuperBuilder
public abstract class BaseEntity {

    @Column(name = "creation_date", nullable = false)
    @JsonIgnore
    protected ZonedDateTime creationDate;

    @Column(name = "update_date", nullable = false)
    @JsonIgnore
    protected ZonedDateTime updateDate;

    @PrePersist
    protected void prePersist() {
        if (creationDate == null) {
            creationDate = ZonedDateTime.now();
        }
        updateDate = ZonedDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        updateDate = ZonedDateTime.now();
    }
}
