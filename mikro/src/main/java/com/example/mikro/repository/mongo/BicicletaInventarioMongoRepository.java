package com.example.mikro.repository.mongo;

import com.example.mikro.model.mongo.BicicletaInventarioMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaInventarioMongoRepository extends MongoRepository<BicicletaInventarioMongo, String> {
    BicicletaInventarioMongo findByInventarioId(Long inventarioId);
    void deleteByInventarioId(Long inventarioId);
}
