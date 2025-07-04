package com.example.mikro.usuario.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.mongo.AlquileresMongo;

@Repository
public interface AlquileresMongoRepository extends MongoRepository<AlquileresMongo, String> {
    AlquileresMongo findByAlquilerId(Long alquilerId);

    // Agrega este método para borrar por alquilerId
    void deleteByAlquilerId(Long alquilerId);
}
