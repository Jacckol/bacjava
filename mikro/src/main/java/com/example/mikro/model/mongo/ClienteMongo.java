package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class ClienteMongo {

    @Id
    private String id;

    private Long clienteIdPostgres;

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String contraseña;

    // Getters y setters
    public String getId() { return id; }
    public Long getClienteIdPostgres() { return clienteIdPostgres; }
    public void setClienteIdPostgres(Long clienteIdPostgres) { this.clienteIdPostgres = clienteIdPostgres; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContraseña() { return contraseña; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
}
