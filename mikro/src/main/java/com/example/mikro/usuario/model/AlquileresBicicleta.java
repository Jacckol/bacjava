package com.example.mikro.usuario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "alquileres_bicicleta")
public class AlquileresBicicleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoBicicleta;
    private String metodoPago;
    private String numeroTarjeta;
    private String fechaExpiracion;
    private String cvc;

    @JsonProperty("titular")
    private String titular;

    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("codigoPostal")
    private String codigoPostal;

    private LocalDateTime fechaHora = LocalDateTime.now();

    // Getters y Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipoBicicleta() { return tipoBicicleta; }
    public void setTipoBicicleta(String tipoBicicleta) { this.tipoBicicleta = tipoBicicleta; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

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
}
