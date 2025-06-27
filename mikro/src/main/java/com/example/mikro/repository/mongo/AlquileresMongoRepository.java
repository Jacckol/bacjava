package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.AlquileresMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquileresMongoRepository extends MongoRepository<AlquileresMongo, String> {
    AlquileresMongo findByAlquilerId(Long alquilerId);

    // Agrega este método para borrar por alquilerId
    void deleteByAlquilerId(Long alquilerId);
}
