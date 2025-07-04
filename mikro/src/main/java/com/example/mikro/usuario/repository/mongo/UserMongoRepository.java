package com.example.mikro.usuario.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.mongo.UserMongo;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, String> {
    UserMongo findByUserIdPostgres(Long userIdPostgres);
}
