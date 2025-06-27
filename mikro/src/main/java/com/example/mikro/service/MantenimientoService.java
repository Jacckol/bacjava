package com.example.mikro.service;

import com.example.mikro.dto.MantenimientoDTO;
import com.example.mikro.model.mongo.MantenimientoMongo;
import com.example.mikro.model.postgres.MantenimientoPostgres;
import com.example.mikro.repository.mongo.MantenimientoMongoRepository;
import com.example.mikro.repository.postgres.MantenimientoPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {

    @Autowired
    private MantenimientoPostgresRepository postgresRepository;

    @Autowired
    private MantenimientoMongoRepository mongoRepository;

    public List<MantenimientoPostgres> obtenerTodos() {
        return postgresRepository.findAll();
    }

    public Optional<MantenimientoPostgres> obtenerPorIdOptional(Long id) {
        return postgresRepository.findById(id);
    }

    public MantenimientoPostgres crear(MantenimientoDTO dto) {
        // Guardar en Postgres
        MantenimientoPostgres postgres = new MantenimientoPostgres();
        postgres.setFechaInicio(dto.getFechaInicio());
        postgres.setTipo(dto.getTipo());
        postgres.setEstacionId(dto.getEstacionId());
        postgres.setDescripcion(dto.getDescripcion());

        MantenimientoPostgres saved = postgresRepository.save(postgres);

        // Guardar en Mongo, referenciando el ID de Postgres
        MantenimientoMongo mongo = new MantenimientoMongo();
        mongo.setMantenimientoPostgresId(saved.getId());
        mongo.setFechaInicio(saved.getFechaInicio());
        mongo.setTipo(saved.getTipo());
        mongo.setEstacionId(saved.getEstacionId());
        mongo.setDescripcion(saved.getDescripcion());

        mongoRepository.save(mongo);

        return saved;
    }

    public MantenimientoPostgres actualizar(Long id, MantenimientoDTO dto) {
        MantenimientoPostgres updated = postgresRepository.findById(id)
                .map(postgres -> {
                    postgres.setFechaInicio(dto.getFechaInicio());
                    postgres.setTipo(dto.getTipo());
                    postgres.setEstacionId(dto.getEstacionId());
                    postgres.setDescripcion(dto.getDescripcion());
                    return postgresRepository.save(postgres);
                }).orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado id: " + id));

        // Actualizar en mongo también
        MantenimientoMongo mongo = mongoRepository.findAll().stream()
            .filter(m -> m.getMantenimientoPostgresId().equals(id))
            .findFirst()
            .orElse(null);

        if (mongo != null) {
            mongo.setFechaInicio(dto.getFechaInicio());
            mongo.setTipo(dto.getTipo());
            mongo.setEstacionId(dto.getEstacionId());
            mongo.setDescripcion(dto.getDescripcion());
            mongoRepository.save(mongo);
        }

        return updated;
    }

    public void eliminar(Long id) {
        postgresRepository.deleteById(id);

        MantenimientoMongo mongo = mongoRepository.findAll().stream()
            .filter(m -> m.getMantenimientoPostgresId().equals(id))
            .findFirst()
            .orElse(null);

        if (mongo != null) {
            mongoRepository.delete(mongo);
        }
    }
}
