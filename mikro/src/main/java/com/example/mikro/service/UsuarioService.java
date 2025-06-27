package com.example.mikro.service;

import com.example.mikro.dto.UsuarioDTO;
import com.example.mikro.model.postgres.UsuarioPostgres;
import com.example.mikro.model.mongo.UsuarioMongo;
import com.example.mikro.repository.postgres.UsuarioPostgresRepository;
import com.example.mikro.repository.mongo.UsuarioMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioPostgresRepository usuarioRepo;

    @Autowired
    private UsuarioMongoRepository usuarioMongoRepo;

    // Guardar en ambos (Postgres y Mongo)
    public UsuarioPostgres registrar(UsuarioDTO dto) {
        UsuarioPostgres usuarioPg = new UsuarioPostgres();
        usuarioPg.setNombre(dto.getNombre());
        usuarioPg.setCorreo(dto.getCorreo());
        usuarioPg.setTelefono(dto.getTelefono());
        usuarioPg.setFechaNacimiento(dto.getFechaNacimiento());
        usuarioPg.setEstado(dto.getEstado());
        usuarioPg.setContraseña(dto.getContraseña());

        usuarioPg = usuarioRepo.save(usuarioPg);

        UsuarioMongo usuarioMongo = new UsuarioMongo();
        usuarioMongo.setUserIdPostgres(usuarioPg.getId());
        usuarioMongo.setNombre(dto.getNombre());
        usuarioMongo.setCorreo(dto.getCorreo());
        usuarioMongo.setTelefono(dto.getTelefono());
        usuarioMongo.setFechaNacimiento(dto.getFechaNacimiento());
        usuarioMongo.setEstado(dto.getEstado());
        usuarioMongo.setContraseña(dto.getContraseña());

        usuarioMongoRepo.save(usuarioMongo);

        return usuarioPg;
    }

    // Buscar por correo
    public Optional<UsuarioPostgres> obtenerPorCorreo(String correo) {
        return usuarioRepo.findByCorreo(correo);
    }

    // Login (verifica correo y contraseña)
    public Optional<UsuarioPostgres> login(String correo, String contraseña) {
        return usuarioRepo.findByCorreoAndContraseña(correo, contraseña);
    }
}
