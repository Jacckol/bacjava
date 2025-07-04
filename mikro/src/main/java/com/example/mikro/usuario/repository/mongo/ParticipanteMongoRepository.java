package com.example.mikro.usuario.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.mikro.usuario.model.mongo.ParticipanteMongo;

@Repository
public interface ParticipanteMongoRepository extends MongoRepository<ParticipanteMongo, String> {

    ParticipanteMongo findByParticipanteIdPostgres(Long participanteIdPostgres);
    
    void deleteByParticipanteIdPostgres(Long participanteIdPostgres);
}
