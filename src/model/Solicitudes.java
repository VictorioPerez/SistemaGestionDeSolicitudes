package model;

public class Solicitudes {

    private int id;
    private String descripcion;
    private TipoSolicitud tipo;
    private Prioridad prioridad;
    private EstadoSolicitud estado;
    private Estudiante estudiante;
    private Responsable responsable;

    public Solicitudes(int id, String descripcion,
                       TipoSolicitud tipo, Prioridad prioridad,
                       EstadoSolicitud estado, Estudiante estudiante) {

        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.estudiante = estudiante;
        this.responsable = null;
    }

    public int getId() {
        return id;
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

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}