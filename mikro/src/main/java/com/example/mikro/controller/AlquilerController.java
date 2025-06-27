package com.example.mikro.controller;

import com.example.mikro.dto.AlquilerDTO;
import com.example.mikro.model.postgres.AlquilerPostgres;
import com.example.mikro.service.AlquilerService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.ALQUILERES)

public class AlquilerController {

    @Autowired
    private AlquilerService alquilerService;

    // Obtener todos los alquileres (Postgres)
    @GetMapping
    public List<AlquilerPostgres> getAll() {
        return alquilerService.obtenerTodos();
    }

    // Obtener un alquiler por ID (Postgres)
    @GetMapping("/{id}")
    public ResponseEntity<AlquilerPostgres> getById(@PathVariable Long id) {
        Optional<AlquilerPostgres> alquiler = alquilerService.obtenerPorId(id);
        return alquiler.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo alquiler (Postgres + Mongo usando DTO)
    @PostMapping
    public ResponseEntity<AlquilerPostgres> create(@RequestBody AlquilerDTO alquilerDTO) {
        AlquilerPostgres nuevo = alquilerService.crearAlquiler(alquilerDTO);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // Actualizar alquiler (Postgres + Mongo)
    @PutMapping("/{id}")
    public ResponseEntity<AlquilerPostgres> update(@PathVariable Long id, @RequestBody AlquilerDTO alquilerDTO) {
        AlquilerPostgres actualizado = alquilerService.actualizarAlquiler(id, alquilerDTO);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar un alquiler (Postgres + Mongo)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alquilerService.eliminarAlquiler(id);
        return ResponseEntity.noContent().build();
    }

    // Buscar alquileres por cliente (en Postgres)
    @GetMapping("/search")
    public List<AlquilerPostgres> search(@RequestParam("q") String query) {
        return alquilerService.buscarPorCliente(query);
    }
}
