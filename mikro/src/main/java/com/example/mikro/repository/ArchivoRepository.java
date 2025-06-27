package com.example.mikro.repository;

import com.example.mikro.model.Archivo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArchivoRepository extends MongoRepository<Archivo, String> {
}
