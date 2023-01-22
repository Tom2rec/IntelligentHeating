package com.heating.system.infrastructure.repository;

import com.heating.system.infrastructure.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
    List<Room> getRoomsByBuilding_Id(UUID buildingId);
    Optional<Room> getRoomById(UUID roomId);
}
