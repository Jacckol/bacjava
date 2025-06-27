package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.UsuarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioMongoRepository extends MongoRepository<UsuarioMongo, String> {
}
