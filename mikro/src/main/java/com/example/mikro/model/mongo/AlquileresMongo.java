package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "alquileres_bicicleta_extra")
public class AlquileresMongo {

    @Id
    private String id;

    private Long alquilerId; // para relacionar con Postgres

    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvc;

    private String titular;
    private String direccion;
    private String codigoPostal;

    private LocalDateTime fechaHora;

    private String estadoAlquiler;
    private String observaciones;

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getAlquilerId() { return alquilerId; }
    public void setAlquilerId(Long alquilerId) { this.alquilerId = alquilerId; }

    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    public String getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public String getCvc() { return cvc; }
    public void setCvc(String cvc) { this.cvc = cvc; }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getEstadoAlquiler() { return estadoAlquiler; }
    public void setEstadoAlquiler(String estadoAlquiler) { this.estadoAlquiler = estadoAlquiler; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
