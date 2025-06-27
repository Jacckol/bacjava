package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.BeaconMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeaconMongoRepository extends MongoRepository<BeaconMongo, String> {
    BeaconMongo findByBeaconId(Long beaconId);
    void deleteByBeaconId(Long beaconId);
}

