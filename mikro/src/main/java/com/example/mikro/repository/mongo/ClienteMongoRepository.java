package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.ClienteMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteMongoRepository extends MongoRepository<ClienteMongo, String> {

    ClienteMongo findByClienteIdPostgres(Long clienteIdPostgres);

    // 🔴 Este es el que falta y causa el error:
    void deleteByClienteIdPostgres(Long clienteIdPostgres);
}
