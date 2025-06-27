package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.AlquilerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerMongoRepository extends MongoRepository<AlquilerMongo, String> {
    void deleteByAlquilerId(Long alquilerId);
    AlquilerMongo findByAlquilerId(Long alquilerId);
}
