package com.example.mikro.controller;

import com.example.mikro.dto.UsuarioDTO;
import com.example.mikro.model.postgres.UsuarioPostgres;
import com.example.mikro.service.UsuarioService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiRoutes.USUARIOS)  // "/api/usuarios"
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioService.obtenerPorCorreo(usuarioDTO.getCorreo()).isPresent()) {
            return ResponseEntity.badRequest().body("Correo ya registrado");
        }
        UsuarioPostgres usuarioCreado = usuarioService.registrar(usuarioDTO);
        return ResponseEntity.ok(usuarioCreado);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO loginDTO) {
        Optional<UsuarioPostgres> userOpt = usuarioService.login(loginDTO.getCorreo(), loginDTO.getContraseña());
        if (userOpt.isPresent()) {
            return ResponseEntity.ok(userOpt.get());
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<?> obtenerPorCorreo(@PathVariable String correo) {
        return usuarioService.obtenerPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
