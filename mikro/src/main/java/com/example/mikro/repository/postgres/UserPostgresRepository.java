package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.UserPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPostgresRepository extends JpaRepository<UserPostgres, Long> {

    Optional<UserPostgres> findByCorreoAndContraseña(String correo, String contraseña);

    Optional<UserPostgres> findByCorreo(String correo);
}
