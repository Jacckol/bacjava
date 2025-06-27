package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.AlquilerPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerPostgresRepository extends JpaRepository<AlquilerPostgres, Long> {
    List<AlquilerPostgres> findByClientContainingIgnoreCase(String keyword);
}
