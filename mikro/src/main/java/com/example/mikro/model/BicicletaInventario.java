package com.example.mikro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventario_bicicletas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BicicletaInventario {

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
}
