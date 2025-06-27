package com.example.mikro.service;

import com.example.mikro.dto.AlquilerDTO;
import com.example.mikro.model.postgres.AlquilerPostgres;
import com.example.mikro.model.mongo.AlquilerMongo;
import com.example.mikro.repository.postgres.AlquilerPostgresRepository;
import com.example.mikro.repository.mongo.AlquilerMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService {

    @Autowired
    private AlquilerPostgresRepository alquilerPostgresRepository;

    @Autowired
    private AlquilerMongoRepository alquilerMongoRepository;

    public List<AlquilerPostgres> obtenerTodos() {
        return alquilerPostgresRepository.findAll();
    }

    public Optional<AlquilerPostgres> obtenerPorId(Long id) {
        return alquilerPostgresRepository.findById(id);
    }

    public AlquilerPostgres crearAlquiler(AlquilerDTO dto) {
        System.out.println("🚀 [crearAlquiler] Iniciando creación de alquiler");

        // Guardar en Postgres con todos los campos asignados
        AlquilerPostgres postgres = new AlquilerPostgres();
        postgres.setClient(dto.getClient());
        postgres.setBikeBrand(dto.getBikeBrand());
        postgres.setRentalDate(dto.getRentalDate());
        postgres.setStatus(dto.getStatus());

        AlquilerPostgres saved = alquilerPostgresRepository.save(postgres);
        System.out.println("✅ [Postgres] Guardado con ID: " + saved.getId());

        // Guardar en Mongo
        AlquilerMongo mongo = new AlquilerMongo();
        mongo.setAlquilerId(saved.getId());
        mongo.setBikeBrand(dto.getBikeBrand());
        mongo.setRentalDate(dto.getRentalDate());
        mongo.setStatus(dto.getStatus());

        System.out.println("📦 [Mongo] Datos: alquilerId=" + mongo.getAlquilerId() +
                ", bikeBrand=" + mongo.getBikeBrand() +
                ", rentalDate=" + mongo.getRentalDate() +
                ", status=" + mongo.getStatus());

        alquilerMongoRepository.save(mongo);
        System.out.println("✅ [Mongo] Guardado correctamente");

        return saved;
    }

    public AlquilerPostgres actualizarAlquiler(Long id, AlquilerDTO dto) {
        System.out.println("✏️ [actualizarAlquiler] ID: " + id);

        // Actualizar en Postgres
        AlquilerPostgres updated = alquilerPostgresRepository.findById(id)
                .map(postgres -> {
                    postgres.setClient(dto.getClient());
                    postgres.setBikeBrand(dto.getBikeBrand());
                    postgres.setRentalDate(dto.getRentalDate());
                    postgres.setStatus(dto.getStatus());
                    return alquilerPostgresRepository.save(postgres);
                })
                .orElseThrow(() -> new RuntimeException("Alquiler no encontrado con id: " + id));
        System.out.println("✅ [Postgres] Actualizado");

        // Actualizar en Mongo
        AlquilerMongo mongo = alquilerMongoRepository.findByAlquilerId(id);
        if (mongo == null) {
            mongo = new AlquilerMongo();
            mongo.setAlquilerId(id);
            System.out.println("ℹ️ [Mongo] No existía, se crea nuevo");
        }

        mongo.setBikeBrand(dto.getBikeBrand());
        mongo.setRentalDate(dto.getRentalDate());
        mongo.setStatus(dto.getStatus());
        alquilerMongoRepository.save(mongo);
        System.out.println("✅ [Mongo] Actualizado");

        return updated;
    }

    public void eliminarAlquiler(Long id) {
        System.out.println("🗑️ [eliminarAlquiler] ID: " + id);
        alquilerPostgresRepository.deleteById(id);
        alquilerMongoRepository.deleteByAlquilerId(id);
        System.out.println("✅ [eliminarAlquiler] Eliminado de Postgres y Mongo");
    }

    public List<AlquilerPostgres> buscarPorCliente(String keyword) {
        System.out.println("🔍 [buscarPorCliente] Buscando: " + keyword);
        return alquilerPostgresRepository.findByClientContainingIgnoreCase(keyword);
    }
}
