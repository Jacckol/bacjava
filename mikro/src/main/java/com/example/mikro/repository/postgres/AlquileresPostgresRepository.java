package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.AlquileresPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquileresPostgresRepository extends JpaRepository<AlquileresPostgres, Long> {
    List<AlquileresPostgres> findByTipoBicicletaContainingIgnoreCase(String keyword);
}
