package DTO;

import model.Prioridad;
import model.TipoSolicitud;

public class DatosSolicitud {

    private String nombreEstudiante;
    private String email;
    private String descripcion;
    private TipoSolicitud tipo;
    private Prioridad prioridad;

    public DatosSolicitud(String nombreEstudiante, String email,
                          String descripcion, TipoSolicitud tipo,
                          Prioridad prioridad) {
        this.nombreEstudiante = nombreEstudiante;
        this.email = email;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getEmail() {
        return email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public TipoSolicitud getTipo() {
        return tipo;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }
}