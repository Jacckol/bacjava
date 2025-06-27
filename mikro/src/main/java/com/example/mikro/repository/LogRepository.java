package com.example.mikro.repository;

import com.example.mikro.model.LogEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogEntry, String> {
    // Métodos básicos ya incluidos: save, findAll, etc.
}
