package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.EstacionPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionPostgresRepository extends JpaRepository<EstacionPostgres, Long> {
}
