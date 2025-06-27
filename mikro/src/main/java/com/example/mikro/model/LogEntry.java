package com.example.mikro.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "logs")
public class LogEntry {

    @Id
    private String id;

    private LocalDateTime fechaHora;  // ← Campo unificado con tus logs existentes
    private String mensaje;           // ← También puedes renombrar este campo

    public LogEntry() {
        this.fechaHora = LocalDateTime.now();
    }

    public LogEntry(String mensaje) {
        this(); // llama al constructor que pone la hora
        this.mensaje = mensaje;
    }

    // Getters y setters

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
