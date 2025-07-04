package com.example.mikro.model.postgres;

import jakarta.persistence.*;

@Entity
@Table(name = "estacion")
public class EstacionPostgres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String ubicacion;
    private int capacidad;
    private String estado;

    public EstacionPostgres() {}

    public EstacionPostgres(String nombre, String ubicacion, int capacidad, String estado) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    // Getters y Setters
    public Long getId() { return id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
