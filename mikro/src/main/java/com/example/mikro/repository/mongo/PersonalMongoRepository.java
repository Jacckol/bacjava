package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.PersonalMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalMongoRepository extends MongoRepository<PersonalMongo, String> {
}
