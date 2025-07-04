package com.example.mikro.usuario.repository.postgres;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mikro.usuario.model.postgres.UserPostgres;

import java.util.Optional;

public interface UserPostgresRepository extends JpaRepository<UserPostgres, Long> {

    Optional<UserPostgres> findByCorreoAndContraseña(String correo, String contraseña);

    Optional<UserPostgres> findByCorreo(String correo);
}
