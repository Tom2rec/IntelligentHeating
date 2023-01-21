package com.heating.system.infrastructure.repository;

import com.heating.system.infrastructure.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BuildingRepository extends JpaRepository<Building, UUID> {
    List<Building> getBuildingsByFaculty_Id(UUID facultyId);
    Optional<Building> getBuildingById(UUID buildingId);
}
