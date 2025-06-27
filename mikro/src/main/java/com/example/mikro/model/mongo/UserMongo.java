package com.example.mikro.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "users")
public class UserMongo {

    @Id
    private String id;

    private Long userIdPostgres;  // Para relacionar con PostgreSQL

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String contraseña;
    private LocalDate fechaNacimiento;

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getUserIdPostgres() { return userIdPostgres; }
    public void setUserIdPostgres(Long userIdPostgres) { this.userIdPostgres = userIdPostgres; }

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

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
