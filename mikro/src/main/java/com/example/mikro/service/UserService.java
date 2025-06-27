package com.example.mikro.service;

import com.example.mikro.dto.UserDTO;
import com.example.mikro.model.postgres.UserPostgres;
import com.example.mikro.model.mongo.UserMongo;
import com.example.mikro.repository.postgres.UserPostgresRepository;
import com.example.mikro.repository.mongo.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserPostgresRepository userRepo;

    @Autowired
    private UserMongoRepository userMongoRepo;

    public boolean login(String correo, String contraseña) {
        Optional<UserPostgres> userOpt = userRepo.findByCorreoAndContraseña(correo, contraseña);
        return userOpt.isPresent();
    }

    public UserPostgres register(UserDTO dto) {
        UserPostgres user = new UserPostgres();
        user.setNombre(dto.getNombre());
        user.setApellido(dto.getApellido());
        user.setCedula(dto.getCedula());
        user.setTelefono(dto.getTelefono());
        user.setCorreo(dto.getCorreo());
        user.setContraseña(dto.getContraseña());
        user.setFechaNacimiento(dto.getFechaNacimiento());

        UserPostgres saved = userRepo.save(user);

        // Guardar también en Mongo, relacionando con el id de Postgres
        UserMongo mongoUser = new UserMongo();
        mongoUser.setUserIdPostgres(saved.getId());
        mongoUser.setNombre(saved.getNombre());
        mongoUser.setApellido(saved.getApellido());
        mongoUser.setCedula(saved.getCedula());
        mongoUser.setTelefono(saved.getTelefono());
        mongoUser.setCorreo(saved.getCorreo());
        mongoUser.setContraseña(saved.getContraseña());
        mongoUser.setFechaNacimiento(saved.getFechaNacimiento());

        userMongoRepo.save(mongoUser);

        return saved;
    }

    public UserPostgres findByCorreo(String correo) {
        Optional<UserPostgres> userOpt = userRepo.findByCorreo(correo);
        return userOpt.orElse(null);
    }
}
