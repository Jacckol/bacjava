package com.example.mikro.service;

import com.example.mikro.dto.ClienteDTO;
import com.example.mikro.model.postgres.ClientePostgres;
import com.example.mikro.model.mongo.ClienteMongo;
import com.example.mikro.repository.postgres.ClientePostgresRepository;
import com.example.mikro.repository.mongo.ClienteMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClientePostgresRepository postgresRepository;

    @Autowired
    private ClienteMongoRepository mongoRepository;

    public ClientePostgres crearCliente(ClienteDTO dto) {
        ClientePostgres postgres = new ClientePostgres();
        postgres.setNombre(dto.getNombre());
        postgres.setApellido(dto.getApellido());
        postgres.setCedula(dto.getCedula());
        postgres.setTelefono(dto.getTelefono());
        postgres.setCorreo(dto.getCorreo());
        postgres.setContraseña(dto.getContraseña());

        ClientePostgres saved = postgresRepository.save(postgres);

        ClienteMongo mongo = new ClienteMongo();
        mongo.setClienteIdPostgres(saved.getId());
        mongo.setNombre(dto.getNombre());
        mongo.setApellido(dto.getApellido());
        mongo.setCedula(dto.getCedula());
        mongo.setTelefono(dto.getTelefono());
        mongo.setCorreo(dto.getCorreo());
        mongo.setContraseña(dto.getContraseña());

        mongoRepository.save(mongo);

        return saved;
    }

    public List<ClientePostgres> obtenerTodos() {
        return postgresRepository.findAll();
    }

    public Optional<ClientePostgres> obtenerPorId(Long id) {
        return postgresRepository.findById(id);
    }

    public ClientePostgres actualizarCliente(Long id, ClienteDTO dto) {
        ClientePostgres updated = postgresRepository.findById(id)
                .map(postgres -> {
                    postgres.setNombre(dto.getNombre());
                    postgres.setApellido(dto.getApellido());
                    postgres.setCedula(dto.getCedula());
                    postgres.setTelefono(dto.getTelefono());
                    postgres.setCorreo(dto.getCorreo());
                    postgres.setContraseña(dto.getContraseña());
                    return postgresRepository.save(postgres);
                }).orElseThrow(() -> new RuntimeException("Cliente no encontrado id: " + id));

        ClienteMongo mongo = mongoRepository.findByClienteIdPostgres(id);
        if (mongo == null) {
            mongo = new ClienteMongo();
            mongo.setClienteIdPostgres(id);
        }
        mongo.setNombre(dto.getNombre());
        mongo.setApellido(dto.getApellido());
        mongo.setCedula(dto.getCedula());
        mongo.setTelefono(dto.getTelefono());
        mongo.setCorreo(dto.getCorreo());
        mongo.setContraseña(dto.getContraseña());

        mongoRepository.save(mongo);

        return updated;
    }

    public void eliminarCliente(Long id) {
        postgresRepository.deleteById(id);
        mongoRepository.deleteByClienteIdPostgres(id);
    }

    // 🔐 LOGIN y búsqueda
    public boolean login(String correo, String contraseña) {
        ClientePostgres cliente = postgresRepository.findByCorreo(correo);
        return cliente != null && cliente.getContraseña().equals(contraseña);
    }

    public ClientePostgres findByCorreo(String correo) {
        return postgresRepository.findByCorreo(correo);
    }
}
