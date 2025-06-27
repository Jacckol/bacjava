package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.ParticipantePostgres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantePostgresRepository extends JpaRepository<ParticipantePostgres, Long> {
    // Puedes agregar métodos personalizados si necesitas
}
