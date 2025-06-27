package com.example.mikro.repository;

import com.example.mikro.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    // Buscar por cliente o bikeBrand con LIKE para búsqueda simple
    @Query("SELECT a FROM Alquiler a WHERE LOWER(a.client) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(a.bikeBrand) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Alquiler> searchByClientOrBikeBrand(String keyword);
}
