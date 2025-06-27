package com.example.mikro.service;

import com.example.mikro.model.Archivo;
import com.example.mikro.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    @Override
    public Archivo guardarArchivo(MultipartFile file) throws Exception {
        Archivo archivo = new Archivo();
        archivo.setNombre(file.getOriginalFilename());
        archivo.setTipoContenido(file.getContentType());
        archivo.setDatos(file.getBytes());

        return archivoRepository.save(archivo);
    }
}
