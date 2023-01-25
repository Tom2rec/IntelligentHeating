package com.heating.system.iotdevice.repository;

import com.heating.system.iotdevice.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long>, MeasurementCustomRepository {

    List<Measurement> findTop15ByPlant_IdOrderByTimestampDesc(Long plantId);
}
