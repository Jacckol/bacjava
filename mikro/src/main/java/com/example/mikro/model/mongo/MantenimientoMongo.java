package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "mantenimientos")
public class MantenimientoMongo {

    @Id
    private String id;

    private Long mantenimientoPostgresId;  // referencia a Postgres
    private LocalDate fechaInicio;
    private String tipo;
    private String estacionId;
    private String descripcion;

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getMantenimientoPostgresId() { return mantenimientoPostgresId; }
    public void setMantenimientoPostgresId(Long mantenimientoPostgresId) { this.mantenimientoPostgresId = mantenimientoPostgresId; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstacionId() { return estacionId; }
    public void setEstacionId(String estacionId) { this.estacionId = estacionId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
