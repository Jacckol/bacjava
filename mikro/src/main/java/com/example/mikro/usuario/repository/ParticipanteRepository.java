package com.example.mikro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}
