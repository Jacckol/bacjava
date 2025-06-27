package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "alquileres_extra")
public class AlquilerMongo {

    @Id
    private String id;
    private Long alquilerId; // ID de Postgres
    private String bikeBrand;
    private LocalDate rentalDate;
    private String status;

    public AlquilerMongo() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getAlquilerId() { return alquilerId; }
    public void setAlquilerId(Long alquilerId) { this.alquilerId = alquilerId; }

    public String getBikeBrand() { return bikeBrand; }
    public void setBikeBrand(String bikeBrand) { this.bikeBrand = bikeBrand; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
