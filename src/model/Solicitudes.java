package model;

public class Solicitudes {

    private int id;
    private String descripcion;
    private String tipo;
    private String prioridad;
    private String estado;

    private Estudiante estudiante;
    private Responsable responsable;

    public Solicitud(
            int id,
            String descripcion,
            String tipo,
            String prioridad,
            String estado,
            Estudiante estudiante
    ) {
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

    public String getTipo() {
        return tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}