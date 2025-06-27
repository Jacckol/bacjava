package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.ClientePostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePostgresRepository extends JpaRepository<ClientePostgres, Long> {
    ClientePostgres findByCorreo(String correo);
}
