package DTO;

import model.Prioridad;
import model.TipoSolicitud;

public class DatosSolicitud {

    private int idEstudiante;
    private String nombreEstudiante;
    private String email;
    private String descripcion;
    private TipoSolicitud tipo;
    private Prioridad prioridad;

    public DatosSolicitud(int idEstudiante, String nombreEstudiante, String email,
                          String descripcion, TipoSolicitud tipo,
                          Prioridad prioridad) {
        this.idEstudiante = idEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.email = email;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
    }

    public int getIdEstudiante(){return idEstudiante;}

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