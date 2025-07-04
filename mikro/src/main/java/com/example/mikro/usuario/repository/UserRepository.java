package com.example.mikro.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mikro.usuario.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Buscar usuario por correo y contraseña (login)
    Optional<User> findByCorreoAndContraseña(String correo, String contraseña);

    // Buscar usuario solo por correo (para validaciones, etc.)
    Optional<User> findByCorreo(String correo);

}
