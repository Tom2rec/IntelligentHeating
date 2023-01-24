package com.heating.system.iotdevice.repository;

import com.heating.system.iotdevice.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    List<Plant> getPlantsByUser_Id(UUID id);

    Optional<Plant> getPlantById(Long id);
    Optional<Plant> getPlantBySensorName(String sensorName);
}
