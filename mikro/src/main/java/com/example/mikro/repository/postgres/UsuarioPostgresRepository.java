// UsuarioPostgresRepository.java
package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.UsuarioPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioPostgresRepository extends JpaRepository<UsuarioPostgres, Long> {
    Optional<UsuarioPostgres> findByCorreo(String correo);
    Optional<UsuarioPostgres> findByCorreoAndContraseña(String correo, String contraseña);  // <- para login
}
