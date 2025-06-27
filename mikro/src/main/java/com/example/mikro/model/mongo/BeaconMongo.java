package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "beacons_extra")
public class BeaconMongo {

    @Id
    private String id;

    private Long beaconId; // Para relacionar con Postgres

    private String estadoBeacon;
    private String observaciones;

    private String serialNumber;
    private LocalDate date;
    private Double longitude;
    private Double latitude;

    // Getters y Setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getBeaconId() { return beaconId; }
    public void setBeaconId(Long beaconId) { this.beaconId = beaconId; }

    public String getEstadoBeacon() { return estadoBeacon; }
    public void setEstadoBeacon(String estadoBeacon) { this.estadoBeacon = estadoBeacon; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }
}
