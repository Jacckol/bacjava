package com.example.mikro.repository;

import com.example.mikro.model.Beacon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BeaconRepository extends JpaRepository<Beacon, Long> {
    Optional<Beacon> findBySerialNumber(String serialNumber);
}
