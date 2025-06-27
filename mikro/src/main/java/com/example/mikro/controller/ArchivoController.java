package com.example.mikro.controller;

import com.example.mikro.model.Archivo;
import com.example.mikro.service.ArchivoService;
import com.example.mikro.routes.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(ApiRoutes.ARCHIVOS)
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    @PostMapping("/subir")
    public Archivo subirArchivo(@RequestParam("file") MultipartFile file) throws Exception {
        return archivoService.guardarArchivo(file);
    }
}
