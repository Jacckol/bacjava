package com.example.mikro.dto;

import java.time.LocalDate;

public class BeaconDTO {

    private String serialNumber;
    private LocalDate date;
    private Double longitude;
    private Double latitude;
    private String estadoBeacon;
    private String observaciones;

    // Getters y Setters

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getEstadoBeacon() {
        return estadoBeacon;
    }
    public void setEstadoBeacon(String estadoBeacon) {
        this.estadoBeacon = estadoBeacon;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
