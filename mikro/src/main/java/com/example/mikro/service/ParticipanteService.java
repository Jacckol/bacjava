package com.example.mikro.service;

import com.example.mikro.model.postgres.ParticipantePostgres;
import com.example.mikro.model.mongo.ParticipanteMongo;
import com.example.mikro.repository.postgres.ParticipantePostgresRepository;
import com.example.mikro.repository.mongo.ParticipanteMongoRepository;
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
