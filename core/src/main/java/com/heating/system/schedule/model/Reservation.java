package com.heating.system.schedule.model;

import com.heating.system.commons.jpa.BaseUUIDEntity;
import com.heating.system.infrastructure.model.Room;
import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation", schema = "heatingsystem")
public class Reservation extends BaseUUIDEntity {

    private ZonedDateTime dateFrom;
    private ZonedDateTime dateTo;
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus = ReservationStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
