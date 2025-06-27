package com.example.mikro.repository.postgres;

import com.example.mikro.model.postgres.PersonalPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalPostgresRepository extends JpaRepository<PersonalPostgres, Long> {
}
