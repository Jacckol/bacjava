package com.example.mikro.model.postgres;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alquileres")
public class AlquilerPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "bike_brand")
    private String bikeBrand;

    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @Column(name = "status")
    private String status;

    public AlquilerPostgres() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public String getBikeBrand() { return bikeBrand; }
    public void setBikeBrand(String bikeBrand) { this.bikeBrand = bikeBrand; }

    public LocalDate getRentalDate() { return rentalDate; }
    public void setRentalDate(LocalDate rentalDate) { this.rentalDate = rentalDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
