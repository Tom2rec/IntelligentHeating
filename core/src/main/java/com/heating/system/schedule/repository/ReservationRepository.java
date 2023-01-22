package com.heating.system.schedule.repository;

import com.heating.system.schedule.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID>, ReservationRepositoryCustom {
    Optional<Reservation> getReservationById(UUID reservationId);
}
