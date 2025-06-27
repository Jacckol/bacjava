package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.MantenimientoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoMongoRepository extends MongoRepository<MantenimientoMongo, String> {
}
