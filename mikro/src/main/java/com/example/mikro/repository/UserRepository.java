package com.example.mikro.repository;

import com.example.mikro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar usuario por correo y contraseña (login)
    Optional<User> findByCorreoAndContraseña(String correo, String contraseña);

    // Buscar usuario solo por correo (para validaciones, etc.)
    Optional<User> findByCorreo(String correo);

}
