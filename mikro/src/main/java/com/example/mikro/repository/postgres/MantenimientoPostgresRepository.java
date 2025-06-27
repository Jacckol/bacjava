package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.MantenimientoPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoPostgresRepository extends JpaRepository<MantenimientoPostgres, Long> {
}
