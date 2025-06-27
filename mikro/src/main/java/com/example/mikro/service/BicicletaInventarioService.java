package com.example.mikro.service;

import com.example.mikro.dto.BicicletaInventarioDTO;
import com.example.mikro.model.postgres.BicicletaInventarioPostgre;
import com.example.mikro.model.mongo.BicicletaInventarioMongo;
import com.example.mikro.repository.postgres.BicicletaInventarioPostgreRepository;
import com.example.mikro.repository.mongo.BicicletaInventarioMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicicletaInventarioService {

    @Autowired
    private BicicletaInventarioPostgreRepository postgresRepository;

    @Autowired
    private BicicletaInventarioMongoRepository mongoRepository;

    // Obtener todos (solo de Postgres)
    public List<BicicletaInventarioPostgre> getAll() {
        return postgresRepository.findAll();
    }

    // Obtener por ID (solo Postgres)
    public Optional<BicicletaInventarioPostgre> getById(Long id) {
        return postgresRepository.findById(id);
    }

    // Guardar (Postgres + Mongo)
    public BicicletaInventarioPostgre save(BicicletaInventarioDTO dto) {
        // Guardar en Postgres
        BicicletaInventarioPostgre entity = new BicicletaInventarioPostgre();
        entity.setBikeBrand(dto.getBikeBrand());
        entity.setBikeModel(dto.getBikeModel());
        entity.setBikeColor(dto.getBikeColor());
        entity.setBikeQuantity(dto.getBikeQuantity());
        entity.setBikeLocation(dto.getBikeLocation());
        entity.setBikeStatus(dto.getBikeStatus());
        BicicletaInventarioPostgre saved = postgresRepository.save(entity);

        // Guardar en Mongo
        BicicletaInventarioMongo mongo = new BicicletaInventarioMongo();
        mongo.setInventarioId(saved.getId());
        mongo.setObservaciones(dto.getObservaciones());
        mongo.setFechaActualizacion(dto.getFechaActualizacion());
        mongoRepository.save(mongo);

        return saved;
    }

    // Actualizar (Postgres + Mongo)
    public BicicletaInventarioPostgre update(Long id, BicicletaInventarioDTO dto) {
        BicicletaInventarioPostgre updated = postgresRepository.findById(id)
            .map(entity -> {
                entity.setBikeBrand(dto.getBikeBrand());
                entity.setBikeModel(dto.getBikeModel());
                entity.setBikeColor(dto.getBikeColor());
                entity.setBikeQuantity(dto.getBikeQuantity());
                entity.setBikeLocation(dto.getBikeLocation());
                entity.setBikeStatus(dto.getBikeStatus());
                return postgresRepository.save(entity);
            })
            .orElseThrow(() -> new RuntimeException("Bicicleta no encontrada con id: " + id));

        BicicletaInventarioMongo mongo = mongoRepository.findByInventarioId(id);
        if (mongo == null) {
            mongo = new BicicletaInventarioMongo();
            mongo.setInventarioId(id);
        }
        mongo.setObservaciones(dto.getObservaciones());
        mongo.setFechaActualizacion(dto.getFechaActualizacion());
        mongoRepository.save(mongo);

        return updated;
    }

    // Eliminar (Postgres + Mongo)
    public void delete(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteByInventarioId(id);
    }
}
