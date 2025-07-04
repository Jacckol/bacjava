package com.example.mikro.usuario.controller;

import com.example.mikro.usuario.dto.AlquilerBicicletaDTO;
import com.example.mikro.usuario.model.postgres.AlquileresPostgres;
import com.example.mikro.usuario.service.AlquileresBicicletaService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.ALQUILERES_BICICLETA)
public class AlquileresBicicletaController {

    @Autowired
    private AlquileresBicicletaService alquilerService;

    // Obtener todos los alquileres (Postgres)
    @GetMapping
    public List<AlquileresPostgres> getAll() {
        return alquilerService.obtenerTodos();
    }

    // Obtener un alquiler por ID (Postgres)
    @GetMapping("/{id}")
    public ResponseEntity<AlquileresPostgres> getById(@PathVariable Long id) {
        Optional<AlquileresPostgres> alquiler = alquilerService.obtenerPorId(id);
        return alquiler.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo alquiler (Postgres + Mongo usando DTO)
    @PostMapping
    public ResponseEntity<AlquileresPostgres> create(@RequestBody AlquilerBicicletaDTO dto) {
        AlquileresPostgres nuevo = alquilerService.registrarAlquiler(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Actualizar alquiler (Postgres + Mongo)
    @PutMapping("/{id}")
    public ResponseEntity<AlquileresPostgres> update(@PathVariable Long id, @RequestBody AlquilerBicicletaDTO dto) {
        AlquileresPostgres actualizado = alquilerService.actualizarAlquiler(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un alquiler (Postgres + Mongo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alquilerService.eliminarAlquiler(id);
        return ResponseEntity.noContent().build();
    }
}
