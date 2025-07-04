package com.example.mikro.usuario.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.postgres.AlquileresPostgres;

import java.util.List;

@Repository
public interface AlquileresPostgresRepository extends JpaRepository<AlquileresPostgres, Long> {
    List<AlquileresPostgres> findByTipoBicicletaContainingIgnoreCase(String keyword);
}
