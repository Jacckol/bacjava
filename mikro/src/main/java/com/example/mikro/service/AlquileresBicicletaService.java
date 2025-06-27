package com.example.mikro.service;

import com.example.mikro.dto.AlquilerBicicletaDTO;
import com.example.mikro.model.postgres.AlquileresPostgres;
import com.example.mikro.model.mongo.AlquileresMongo;
import com.example.mikro.repository.postgres.AlquileresPostgresRepository;
import com.example.mikro.repository.mongo.AlquileresMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquileresBicicletaService {

    @Autowired
    private AlquileresPostgresRepository postgresRepository;

    @Autowired
    private AlquileresMongoRepository mongoRepository;

    // Guardar un alquiler
    public AlquileresPostgres registrarAlquiler(AlquilerBicicletaDTO dto) {
        // Guardar TODOS los campos en Postgres
        AlquileresPostgres postgres = new AlquileresPostgres();
        postgres.setTipoBicicleta(dto.getTipoBicicleta());
        postgres.setMetodoPago(dto.getMetodoPago());
        postgres.setNumeroTarjeta(dto.getNumeroTarjeta());
        postgres.setFechaExpiracion(dto.getFechaExpiracion());
        postgres.setCvc(dto.getCvc());
        postgres.setTitular(dto.getTitular());
        postgres.setDireccion(dto.getDireccion());
        postgres.setCodigoPostal(dto.getCodigoPostal());
        postgres.setFechaHora(dto.getFechaHora());
        postgres.setEstadoAlquiler(dto.getEstadoAlquiler());
        postgres.setObservaciones(dto.getObservaciones());

        AlquileresPostgres saved = postgresRepository.save(postgres);

        // Guardar campos menos importantes (o adicionales) en Mongo si quieres
        AlquileresMongo mongo = new AlquileresMongo();
        mongo.setAlquilerId(saved.getId());
        mongo.setEstadoAlquiler(dto.getEstadoAlquiler());
        mongo.setObservaciones(dto.getObservaciones());
        // Si quieres guardar también otros campos en Mongo, agrégalos aquí

        mongoRepository.save(mongo);

        return saved;
    }

    // Obtener todos
    public List<AlquileresPostgres> obtenerTodos() {
        return postgresRepository.findAll();
    }

    // Obtener por ID
    public Optional<AlquileresPostgres> obtenerPorId(Long id) {
        return postgresRepository.findById(id);
    }

    // Actualizar
    public AlquileresPostgres actualizarAlquiler(Long id, AlquilerBicicletaDTO dto) {
        AlquileresPostgres updated = postgresRepository.findById(id)
                .map(postgres -> {
                    postgres.setTipoBicicleta(dto.getTipoBicicleta());
                    postgres.setMetodoPago(dto.getMetodoPago());
                    postgres.setNumeroTarjeta(dto.getNumeroTarjeta());
                    postgres.setFechaExpiracion(dto.getFechaExpiracion());
                    postgres.setCvc(dto.getCvc());
                    postgres.setTitular(dto.getTitular());
                    postgres.setDireccion(dto.getDireccion());
                    postgres.setCodigoPostal(dto.getCodigoPostal());
                    postgres.setFechaHora(dto.getFechaHora());
                    postgres.setEstadoAlquiler(dto.getEstadoAlquiler());
                    postgres.setObservaciones(dto.getObservaciones());
                    return postgresRepository.save(postgres);
                })
                .orElseThrow(() -> new RuntimeException("No encontrado id: " + id));

        // Actualizar Mongo
        AlquileresMongo mongo = mongoRepository.findByAlquilerId(id);
        if (mongo == null) {
            mongo = new AlquileresMongo();
            mongo.setAlquilerId(id);
        }
        mongo.setEstadoAlquiler(dto.getEstadoAlquiler());
        mongo.setObservaciones(dto.getObservaciones());
        // Más campos para Mongo si deseas

        mongoRepository.save(mongo);

        return updated;
    }

    // Eliminar
    public void eliminarAlquiler(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteByAlquilerId(id);
    }
}
