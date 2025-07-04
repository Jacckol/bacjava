package com.example.mikro.usuario.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "participantes")
public class ParticipanteMongo {

    @Id
    private String id;

    private Long participanteIdPostgres;  // Relaciona con Postgres si quieres

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String correo;
    private String tipoParticipante;
    private String descripcion;
    private String email;

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getParticipanteIdPostgres() { return participanteIdPostgres; }
    public void setParticipanteIdPostgres(Long participanteIdPostgres) { this.participanteIdPostgres = participanteIdPostgres; }

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

    public String getTipoParticipante() { return tipoParticipante; }
    public void setTipoParticipante(String tipoParticipante) { this.tipoParticipante = tipoParticipante; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
