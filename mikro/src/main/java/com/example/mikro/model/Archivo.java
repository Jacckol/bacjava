package com.example.mikro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "archivos")
public class Archivo {

    @Id
    private String id;

    private String nombre;
    private String tipoContenido;
    private byte[] datos;

    // Getters y setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoContenido() {
        return tipoContenido;
    }
    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }
    public byte[] getDatos() {
        return datos;
    }
    public void setDatos(byte[] datos) {
        this.datos = datos;
    }
}
