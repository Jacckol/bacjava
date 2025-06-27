package com.example.mikro.controller;

import com.example.mikro.dto.BeaconDTO;
import com.example.mikro.model.postgres.BeaconPostgres;
import com.example.mikro.service.BeaconService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.BEACONS)
public class BeaconController {

    @Autowired
    private BeaconService beaconService;

    @GetMapping
    public List<BeaconPostgres> getAllBeacons() {
        return beaconService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeaconPostgres> getBeaconById(@PathVariable Long id) {
        Optional<BeaconPostgres> beacon = beaconService.obtenerPorId(id);
        return beacon.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BeaconPostgres> createBeacon(@RequestBody BeaconDTO dto) {
        BeaconPostgres nuevoBeacon = beaconService.crearBeacon(dto);
        return new ResponseEntity<>(nuevoBeacon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeaconPostgres> updateBeacon(@PathVariable Long id, @RequestBody BeaconDTO dto) {
        BeaconPostgres beaconActualizado = beaconService.actualizarBeacon(id, dto);
        return ResponseEntity.ok(beaconActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeacon(@PathVariable Long id) {
        beaconService.eliminarBeacon(id);
        return ResponseEntity.noContent().build();
    }
}
