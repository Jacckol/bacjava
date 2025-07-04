package com.example.mikro.usuario.service;

import com.example.mikro.usuario.model.mongo.ParticipanteMongo;
import com.example.mikro.usuario.model.postgres.ParticipantePostgres;
import com.example.mikro.usuario.repository.mongo.ParticipanteMongoRepository;
import com.example.mikro.usuario.repository.postgres.ParticipantePostgresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParticipanteService {

    @Autowired
    private ParticipantePostgresRepository postgresRepo;

    @Autowired
    private ParticipanteMongoRepository mongoRepo;

    // Registrar en ambos
    public ParticipantePostgres registrar(ParticipantePostgres participante) {
        ParticipantePostgres guardado = postgresRepo.save(participante);

        ParticipanteMongo mongo = new ParticipanteMongo();
        mongo.setParticipanteIdPostgres(guardado.getId());
        mongo.setNombre(guardado.getNombre());
        mongo.setApellido(guardado.getApellido());
        mongo.setCedula(guardado.getCedula());
        mongo.setTelefono(guardado.getTelefono());
        mongo.setCorreo(guardado.getCorreo());
        mongo.setTipoParticipante(guardado.getTipoParticipante());
        mongo.setDescripcion(guardado.getDescripcion());
        mongo.setEmail(guardado.getEmail());

        mongoRepo.save(mongo);

        return guardado;
    }

    public List<ParticipantePostgres> obtenerTodos() {
        return postgresRepo.findAll();
    }

    public Optional<ParticipantePostgres> obtenerPorId(Long id) {
        return postgresRepo.findById(id);
    }

    public ParticipantePostgres actualizar(Long id, ParticipantePostgres actualizado) {
        actualizado.setId(id);
        ParticipantePostgres guardado = postgresRepo.save(actualizado);

        ParticipanteMongo mongo = mongoRepo.findByParticipanteIdPostgres(id);
        if (mongo != null) {
            mongo.setNombre(guardado.getNombre());
            mongo.setApellido(guardado.getApellido());
            mongo.setCedula(guardado.getCedula());
            mongo.setTelefono(guardado.getTelefono());
            mongo.setCorreo(guardado.getCorreo());
            mongo.setTipoParticipante(guardado.getTipoParticipante());
            mongo.setDescripcion(guardado.getDescripcion());
            mongo.setEmail(guardado.getEmail());
            mongoRepo.save(mongo);
        }

        return guardado;
    }

    public void eliminar(Long id) {
        postgresRepo.deleteById(id);
        mongoRepo.deleteByParticipanteIdPostgres(id);
    }
}
