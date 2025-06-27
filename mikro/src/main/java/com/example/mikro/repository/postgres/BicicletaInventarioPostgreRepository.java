package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.BicicletaInventarioPostgre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BicicletaInventarioPostgreRepository extends JpaRepository<BicicletaInventarioPostgre, Long> {
}
