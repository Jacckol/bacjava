package com.example.mikro.controller;

import com.example.mikro.dto.ClienteDTO;
import com.example.mikro.model.postgres.ClientePostgres;
import com.example.mikro.service.ClienteService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRoutes.CLIENTES)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Login - aquí puedes decidir si usar DTO o entidad, lo que prefieras
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ClienteDTO loginRequest) {
        boolean valid = clienteService.login(loginRequest.getCorreo(), loginRequest.getContraseña());
        if (valid) {
            ClientePostgres cliente = clienteService.findByCorreo(loginRequest.getCorreo());
            return ResponseEntity.ok().body(cliente);
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }

    // Registro usando DTO
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ClienteDTO newClienteDto) {
        if (clienteService.findByCorreo(newClienteDto.getCorreo()) != null) {
            return ResponseEntity.badRequest().body("Correo ya registrado");
        }
        ClientePostgres created = clienteService.crearCliente(newClienteDto);
        return ResponseEntity.ok(created);
    }
}
