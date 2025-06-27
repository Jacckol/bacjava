package com.example.mikro.dto;

import java.time.LocalDateTime;

public class BicicletaInventarioDTO {

    // Campos para Postgres
    private String bikeBrand;
    private String bikeModel;
    private String bikeColor;
    private int bikeQuantity;
    private String bikeLocation;
    private String bikeStatus;

    // Campos para Mongo
    private String observaciones;
    private LocalDateTime fechaActualizacion;

    // Getters y setters

    public String getBikeBrand() {
        return bikeBrand;
    }

    public void setBikeBrand(String bikeBrand) {
        this.bikeBrand = bikeBrand;
    }

    public String getBikeModel() {
        return bikeModel;
    }

    public void setBikeModel(String bikeModel) {
        this.bikeModel = bikeModel;
    }

    public String getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(String bikeColor) {
        this.bikeColor = bikeColor;
    }

    public int getBikeQuantity() {
        return bikeQuantity;
    }

    public void setBikeQuantity(int bikeQuantity) {
        this.bikeQuantity = bikeQuantity;
    }

    public String getBikeLocation() {
        return bikeLocation;
    }

    public void setBikeLocation(String bikeLocation) {
        this.bikeLocation = bikeLocation;
    }

    public String getBikeStatus() {
        return bikeStatus;
    }

    public void setBikeStatus(String bikeStatus) {
        this.bikeStatus = bikeStatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
