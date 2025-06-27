package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.ParticipanteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteMongoRepository extends MongoRepository<ParticipanteMongo, String> {

    ParticipanteMongo findByParticipanteIdPostgres(Long participanteIdPostgres);
    
    void deleteByParticipanteIdPostgres(Long participanteIdPostgres);
}
