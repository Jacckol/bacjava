package com.example.mikro.service;

import com.example.mikro.model.Archivo;
import org.springframework.web.multipart.MultipartFile;

public interface ArchivoService {
    Archivo guardarArchivo(MultipartFile file) throws Exception;
}
