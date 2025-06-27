package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.EstacionMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstacionMongoRepository extends MongoRepository<EstacionMongo, String> {
    void deleteByEstacionIdPostgres(Long id);
    EstacionMongo findByEstacionIdPostgres(Long id);
}
