package com.example.mikro.controller;

import com.example.mikro.dto.MantenimientoDTO;
import com.example.mikro.model.postgres.MantenimientoPostgres;
import com.example.mikro.service.MantenimientoService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.MANTENIMIENTOS)
public class MantenimientoController {

    @Autowired
    private MantenimientoService mantenimientoService;

    @GetMapping
    public List<MantenimientoPostgres> getAll() {
        return mantenimientoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MantenimientoPostgres> getById(@PathVariable Long id) {
        Optional<MantenimientoPostgres> mantenimiento = mantenimientoService.obtenerPorIdOptional(id);
        return mantenimiento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MantenimientoPostgres> create(@RequestBody MantenimientoDTO dto) {
        MantenimientoPostgres created = mantenimientoService.crear(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MantenimientoPostgres> update(@PathVariable Long id, @RequestBody MantenimientoDTO dto) {
        MantenimientoPostgres updated = mantenimientoService.actualizar(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mantenimientoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
