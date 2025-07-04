package com.example.mikro.service;

import com.example.mikro.dto.EstacionDTO;
import com.example.mikro.model.mongo.EstacionMongo;
import com.example.mikro.model.postgres.EstacionPostgres;
import com.example.mikro.repository.mongo.EstacionMongoRepository;
import com.example.mikro.repository.postgres.EstacionPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EstacionService {

    @Autowired
    private EstacionPostgresRepository postgresRepository;

    @Autowired
    private EstacionMongoRepository mongoRepository;

    public EstacionPostgres crear(EstacionDTO dto) {
        // Usa los valores reales de capacidad y estado
        EstacionPostgres p = new EstacionPostgres(
            dto.getNombre(),
            dto.getUbicacion(),
            dto.getCapacidad(),
            dto.getEstado()
        );
        EstacionPostgres saved = postgresRepository.save(p);

        EstacionMongo m = new EstacionMongo();
        m.setEstacionIdPostgres(saved.getId());
        m.setNombre(dto.getNombre());
        m.setUbicacion(dto.getUbicacion());

        mongoRepository.save(m);

        return saved;
    }

    public List<EstacionPostgres> obtenerTodas() {
        return postgresRepository.findAll();
    }

    public Optional<EstacionPostgres> obtenerPorId(Long id) {
        return postgresRepository.findById(id);
    }

    public EstacionPostgres actualizar(Long id, EstacionDTO dto) {
        EstacionPostgres updated = postgresRepository.findById(id)
                .map(p -> {
                    p.setNombre(dto.getNombre());
                    p.setUbicacion(dto.getUbicacion());
                    p.setCapacidad(dto.getCapacidad()); // actualiza capacidad
                    p.setEstado(dto.getEstado());       // actualiza estado
                    return postgresRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Estación no encontrada"));

        EstacionMongo m = mongoRepository.findByEstacionIdPostgres(id);
        if (m == null) {
            m = new EstacionMongo();
            m.setEstacionIdPostgres(id);
        }
        m.setNombre(dto.getNombre());
        m.setUbicacion(dto.getUbicacion());

        mongoRepository.save(m);

        return updated;
    }

    public void eliminar(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteByEstacionIdPostgres(id);
    }
}
