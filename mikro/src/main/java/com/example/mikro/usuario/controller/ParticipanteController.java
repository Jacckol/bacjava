package com.example.mikro.usuario.controller;

import com.example.mikro.usuario.model.postgres.ParticipantePostgres;
import com.example.mikro.usuario.service.ParticipanteService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.PARTICIPANTES)
public class ParticipanteController {

    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public ResponseEntity<ParticipantePostgres> crearParticipante(@RequestBody ParticipantePostgres participante) {
        ParticipantePostgres nuevo = participanteService.registrar(participante);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<ParticipantePostgres>> listarTodos() {
        List<ParticipantePostgres> lista = participanteService.obtenerTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<ParticipantePostgres> participante = participanteService.obtenerPorId(id);
        if (participante.isPresent()) {
            return ResponseEntity.ok(participante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarParticipante(@PathVariable Long id, @RequestBody ParticipantePostgres participante) {
        Optional<ParticipantePostgres> existente = participanteService.obtenerPorId(id);
        if (existente.isPresent()) {
            participante.setId(id);
ParticipantePostgres actualizado = participanteService.actualizar(id, participante);
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarParticipante(@PathVariable Long id) {
        Optional<ParticipantePostgres> existente = participanteService.obtenerPorId(id);
        if (existente.isPresent()) {
            participanteService.eliminar(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
