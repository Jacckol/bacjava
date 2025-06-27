package com.example.mikro.repository;

import com.example.mikro.model.BicicletaInventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BicicletaInventarioRepository extends JpaRepository<BicicletaInventario, Long> {
    List<BicicletaInventario> findByBikeBrandContainingIgnoreCaseOrBikeModelContainingIgnoreCase(String brand, String model);
}
