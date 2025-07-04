package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estacion")
public class EstacionMongo {

    @Id
    private String id;

    private Long estacionIdPostgres;
    private String nombre;
    private String ubicacion;

    public EstacionMongo() {}

    // Getters y Setters
    public String getId() { return id; }
    public Long getEstacionIdPostgres() { return estacionIdPostgres; }
    public void setEstacionIdPostgres(Long estacionIdPostgres) { this.estacionIdPostgres = estacionIdPostgres; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}
