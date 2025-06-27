package com.example.mikro.service;

import com.example.mikro.dto.PersonalDTO;
import com.example.mikro.model.mongo.PersonalMongo;
import com.example.mikro.model.postgres.PersonalPostgres;
import com.example.mikro.repository.mongo.PersonalMongoRepository;
import com.example.mikro.repository.postgres.PersonalPostgresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonalService {

    @Autowired
    private PersonalPostgresRepository postgresRepository;

    @Autowired
    private PersonalMongoRepository mongoRepository;

    public PersonalDTO guardar(PersonalDTO dto) {
        // Guardar en PostgreSQL
        PersonalPostgres postgres = mapToPostgres(dto);
        postgres = postgresRepository.save(postgres);

        // Guardar en Mongo
        PersonalMongo mongo = mapToMongo(dto);
        mongo.setId(postgres.getId().toString()); // Para sincronizar ID
        mongoRepository.save(mongo);

        return mapToDTO(postgres);
    }

    public List<PersonalDTO> obtenerTodos() {
        return postgresRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PersonalDTO> obtenerPorId(Long id) {
        return postgresRepository.findById(id).map(this::mapToDTO);
    }

    public PersonalDTO actualizar(Long id, PersonalDTO dto) {
        dto.setId(id);
        return guardar(dto); // Reutilizamos guardar()
    }

    public void eliminar(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteById(id.toString());
    }

    // ======== Mappers ========
    private PersonalDTO mapToDTO(PersonalPostgres p) {
        PersonalDTO dto = new PersonalDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setCorreo(p.getCorreo());
        dto.setTelefono(p.getTelefono());
        dto.setFechaNacimiento(p.getFechaNacimiento());
        dto.setEstado(p.getEstado());
        return dto;
    }

    private PersonalPostgres mapToPostgres(PersonalDTO dto) {
        PersonalPostgres p = new PersonalPostgres();
        p.setId(dto.getId());
        p.setNombre(dto.getNombre());
        p.setCorreo(dto.getCorreo());
        p.setTelefono(dto.getTelefono());
        p.setFechaNacimiento(dto.getFechaNacimiento());
        p.setEstado(dto.getEstado());
        return p;
    }

    private PersonalMongo mapToMongo(PersonalDTO dto) {
        PersonalMongo p = new PersonalMongo();
        p.setId(dto.getId() != null ? dto.getId().toString() : null);
        p.setNombre(dto.getNombre());
        p.setCorreo(dto.getCorreo());
        p.setTelefono(dto.getTelefono());
        p.setFechaNacimiento(dto.getFechaNacimiento());
        p.setEstado(dto.getEstado());
        return p;
    }
}
