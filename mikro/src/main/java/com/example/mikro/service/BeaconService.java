package com.example.mikro.service;

import com.example.mikro.dto.BeaconDTO;
import com.example.mikro.model.postgres.BeaconPostgres;
import com.example.mikro.model.mongo.BeaconMongo;
import com.example.mikro.repository.postgres.BeaconPostgresRepository;
import com.example.mikro.repository.mongo.BeaconMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeaconService {

    @Autowired
    private BeaconPostgresRepository postgresRepository;

    @Autowired
    private BeaconMongoRepository mongoRepository;

    public BeaconPostgres crearBeacon(BeaconDTO dto) {
        // Guardar en Postgres
        BeaconPostgres beacon = new BeaconPostgres();
        beacon.setSerialNumber(dto.getSerialNumber());
        beacon.setDate(dto.getDate());
        beacon.setLongitude(dto.getLongitude());
        beacon.setLatitude(dto.getLatitude());
        beacon.setEstadoBeacon(dto.getEstadoBeacon());
        beacon.setObservaciones(dto.getObservaciones());

        BeaconPostgres saved = postgresRepository.save(beacon);

        // Guardar en Mongo con referencia a Postgres
        BeaconMongo mongo = new BeaconMongo();
        mongo.setBeaconId(saved.getId());
        mongo.setSerialNumber(dto.getSerialNumber());
        mongo.setDate(dto.getDate());
        mongo.setLongitude(dto.getLongitude());
        mongo.setLatitude(dto.getLatitude());
        mongo.setEstadoBeacon(dto.getEstadoBeacon());
        mongo.setObservaciones(dto.getObservaciones());

        mongoRepository.save(mongo);

        return saved;
    }

    public List<BeaconPostgres> obtenerTodos() {
        return postgresRepository.findAll();
    }

    public Optional<BeaconPostgres> obtenerPorId(Long id) {
        return postgresRepository.findById(id);
    }

    public BeaconPostgres actualizarBeacon(Long id, BeaconDTO dto) {
        BeaconPostgres updated = postgresRepository.findById(id)
                .map(beacon -> {
                    beacon.setSerialNumber(dto.getSerialNumber());
                    beacon.setDate(dto.getDate());
                    beacon.setLongitude(dto.getLongitude());
                    beacon.setLatitude(dto.getLatitude());
                    beacon.setEstadoBeacon(dto.getEstadoBeacon());
                    beacon.setObservaciones(dto.getObservaciones());
                    return postgresRepository.save(beacon);
                })
                .orElseThrow(() -> new RuntimeException("No encontrado id: " + id));

        BeaconMongo mongo = mongoRepository.findByBeaconId(id);
        if (mongo == null) {
            mongo = new BeaconMongo();
            mongo.setBeaconId(id);
        }
        mongo.setSerialNumber(dto.getSerialNumber());
        mongo.setDate(dto.getDate());
        mongo.setLongitude(dto.getLongitude());
        mongo.setLatitude(dto.getLatitude());
        mongo.setEstadoBeacon(dto.getEstadoBeacon());
        mongo.setObservaciones(dto.getObservaciones());

        mongoRepository.save(mongo);

        return updated;
    }

    public void eliminarBeacon(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteByBeaconId(id);
    }
}
