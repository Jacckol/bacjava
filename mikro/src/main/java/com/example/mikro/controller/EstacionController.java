package com.example.mikro.controller;

import com.example.mikro.dto.EstacionDTO;
import com.example.mikro.model.postgres.EstacionPostgres;
import com.example.mikro.routes.ApiRoutes;
import com.example.mikro.service.EstacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiRoutes.ESTACION)
public class EstacionController {

    @Autowired
    private EstacionService estacionService;

    @PostMapping
    public ResponseEntity<EstacionPostgres> crear(@RequestBody EstacionDTO dto) {
        return ResponseEntity.ok(estacionService.crear(dto));
    }

    @GetMapping
    public ResponseEntity<List<EstacionPostgres>> obtenerTodas() {
        return ResponseEntity.ok(estacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return estacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody EstacionDTO dto) {
        return ResponseEntity.ok(estacionService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        estacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
