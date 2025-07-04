package com.example.mikro.usuario.controller;

import com.example.mikro.usuario.dto.UserDTO;
import com.example.mikro.usuario.model.postgres.UserPostgres;
import com.example.mikro.usuario.service.UserService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiRoutes.USER)  // por ejemplo "/api/usuarios"
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO loginRequest) {
        boolean valid = userService.login(loginRequest.getCorreo(), loginRequest.getContraseña());
        if (valid) {
            UserPostgres user = userService.findByCorreo(loginRequest.getCorreo());
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Correo o contraseña incorrectos");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO newUserDto) {
        if (userService.findByCorreo(newUserDto.getCorreo()) != null) {
            return ResponseEntity.badRequest().body("Correo ya registrado");
        }
        UserPostgres created = userService.register(newUserDto);
        return ResponseEntity.ok(created);
    }
}
