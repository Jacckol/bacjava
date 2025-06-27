package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    UserMongo findByUserIdPostgres(Long userIdPostgres);
}
