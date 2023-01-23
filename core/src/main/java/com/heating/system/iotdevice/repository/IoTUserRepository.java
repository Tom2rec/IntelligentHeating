package com.heating.system.iotdevice.repository;

import com.heating.system.iotdevice.model.IoTUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IoTUserRepository extends JpaRepository<IoTUser, UUID> {
    Optional<IoTUser> getUserById(UUID id);

    Optional<IoTUser> getUserByEmail(String email);
}
