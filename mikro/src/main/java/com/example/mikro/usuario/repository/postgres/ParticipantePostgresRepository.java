package com.example.mikro.usuario.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.postgres.ParticipantePostgres;

@Repository
public interface ParticipantePostgresRepository extends JpaRepository<ParticipantePostgres, Long> {
    // Puedes agregar métodos personalizados si necesitas
}
