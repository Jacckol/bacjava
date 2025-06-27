package com.example.mikro.repository;

import com.example.mikro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // puedes agregar consultas personalizadas si quieres, ej:
    // Optional<Usuario> findByCorreo(String correo);
}
