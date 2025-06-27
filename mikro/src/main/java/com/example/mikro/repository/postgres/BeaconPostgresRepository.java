package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.BeaconPostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconPostgresRepository extends JpaRepository<BeaconPostgres, Long> {
    // Puedes agregar métodos de consulta personalizados si los necesitas
}
