package com.heating.system.schedule.repository;

import com.heating.system.commons.jpa.AbstractBaseRepository;
import com.heating.system.infrastructure.model.Room_;
import com.heating.system.schedule.model.Reservation;
import com.heating.system.schedule.model.Reservation_;
import com.heating.system.schedule.model.enumeration.ReservationStatus;
import com.heating.system.user.model.User_;

import javax.persistence.criteria.Predicate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public class ReservationRepositoryCustomImpl extends AbstractBaseRepository implements ReservationRepositoryCustom {
    @Override
    public List<Reservation> getReservationsByRoomIdAndDatesAndReservationStatus(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, ReservationStatus status) {
        var query = cb.createQuery(Reservation.class);
        var root = query.from(Reservation.class);
        var roomJoin = root.join(Reservation_.room);

        Predicate statusPredicate = cb.and();
        if(status != null) {
            statusPredicate = cb.equal(root.get(Reservation_.reservationStatus), status);
        }

        query.select(root);
        query.where(cb.and(
                cb.equal(roomJoin.get(Room_.id), roomId),
                cb.greaterThanOrEqualTo(root.get(Reservation_.dateFrom), dateFrom),
                cb.lessThanOrEqualTo(root.get(Reservation_.dateTo), dateTo),
                statusPredicate
        ));

        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Reservation> getReservationsByRoomIdAndDatesAndUserId(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo, UUID userId) {
        var query = cb.createQuery(Reservation.class);
        var root = query.from(Reservation.class);
        var roomJoin = root.join(Reservation_.room);
        var userJoin = root.join(Reservation_.user);

        query.select(root);
        query.where(cb.and(
                cb.equal(roomJoin.get(Room_.id), roomId),
                cb.greaterThanOrEqualTo(root.get(Reservation_.dateFrom), dateFrom),
                cb.lessThanOrEqualTo(root.get(Reservation_.dateTo), dateTo),
                cb.equal(userJoin.get(User_.id), userId)
        ));

        return em.createQuery(query).getResultList();
    }

    @Override
    public List<Reservation> getReservationForValidation(UUID roomId, ZonedDateTime dateFrom, ZonedDateTime dateTo) {
        var query = cb.createQuery(Reservation.class);
        var root = query.from(Reservation.class);
        var roomJoin = root.join(Reservation_.room);

        query.select(root);
        query.where(cb.and(
                cb.equal(roomJoin.get(Room_.id), roomId),
                cb.or(
                        cb.between(root.get(Reservation_.dateFrom), dateFrom, dateTo),
                        cb.between(root.get(Reservation_.dateTo), dateFrom, dateTo)
                ),
                cb.equal(root.get(Reservation_.reservationStatus), ReservationStatus.ACCEPTED)
        ));

        return em.createQuery(query).getResultList();
    }
}
