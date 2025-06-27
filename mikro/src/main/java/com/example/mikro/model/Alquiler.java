package com.example.mikro.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alquileres")
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bike_brand", nullable = false)
    private String bikeBrand;

    @Column(nullable = false)
    private String client;

    @Column(name = "rental_date", nullable = false)
    private LocalDate rentalDate;

    @Column(nullable = false)
    private String status;  // "active", "returned"

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBikeBrand() { return bikeBrand; }
    public void setBikeBrand(String bikeBrand) { this.bikeBrand = bikeBrand; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
