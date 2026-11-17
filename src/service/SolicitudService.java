package service;

import DTO.DatosSolicitud;
import model.*;
import repository.SolicitudRepository;

import java.util.List;

public class SolicitudService {

    private final SolicitudRepository repository;
    private int siguienteId = 1;

    public SolicitudService(SolicitudRepository repository) {
        this.repository = repository;
    }

    public Solicitudes registrarSolicitud(DatosSolicitud datos) {

        Estudiante estudiante = new Estudiante(
                datos.getIdEstudiante(),
                datos.getNombreEstudiante(),
                datos.getEmail()
        );

        Solicitudes solicitud = new Solicitudes(
                siguienteId++,
                datos.getDescripcion(),
                datos.getTipo(),
                datos.getPrioridad(),
                EstadoSolicitud.PENDIENTE,
                estudiante
        );

        repository.guardar(solicitud);

        return solicitud;
    }

    public void cambiarEstado(int id, EstadoSolicitud nuevoEstado) {
        Solicitudes solicitud = buscarSolicitud(id);
        solicitud.setEstado(nuevoEstado);
    }

    public void asignarResponsable(int id, Responsable responsable) {
        Solicitudes solicitud = buscarSolicitud(id);
        solicitud.setResponsable(responsable);
    }

    public Solicitudes buscarSolicitud(int id) {
        Solicitudes solicitud = repository.buscarPorId(id);

        if (solicitud == null) {
            throw new IllegalArgumentException(
                    "No existe una solicitud con el ID indicado."
            );
        }

        return solicitud;
    }

    public List<Solicitudes> obtenerSolicitudes() {
        return repository.obtenerTodas();
    }
}