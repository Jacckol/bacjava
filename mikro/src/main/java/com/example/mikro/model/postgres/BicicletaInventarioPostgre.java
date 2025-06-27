package com.example.mikro.model.postgres;

import jakarta.persistence.*;

@Entity
@Table(name = "inventario_bicicletas")
public class BicicletaInventarioPostgre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bike_brand", nullable = false)
    private String bikeBrand;

    @Column(name = "bike_model", nullable = false)
    private String bikeModel;

    @Column(name = "bike_color", nullable = false)
    private String bikeColor;

    @Column(name = "bike_quantity", nullable = false)
    private int bikeQuantity;

    @Column(name = "bike_location", nullable = false)
    private String bikeLocation;

    @Column(name = "bike_status", nullable = false)
    private String bikeStatus;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
