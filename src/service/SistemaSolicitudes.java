package service;

import model.Estudiante;
import model.Responsable;
import model.Solicitudes;

import java.util.ArrayList;
import java.util.List;

public class SistemaSolicitudes {

    private List<Solicitudes> solicitudes = new ArrayList<>();

    // Registrar una solicitud
    public void registrarSolicitud(
            int id,
            String nombre,
            String email,
            String descripcion,
            String tipo,
            String prioridad
    ) {

        Estudiante estudiante = new Estudiante(
                id,
                nombre,
                email
        );

        Solicitudes solicitud = new Solicitudes(
                id,
                descripcion,
                tipo,
                prioridad,
                "PENDIENTE",
                estudiante
        );

        solicitudes.add(solicitud);

        System.out.println("Solicitud registrada correctamente.");
    }

    // Buscar una solicitud por ID
    public Solicitudes buscarPorId(int id) {

        for (Solicitudes solicitud : solicitudes) {

            if (solicitud.getId() == id) {
                return solicitud;
            }
        }

        return null;
    }

    // Cambiar el estado de una solicitud
    public void cambiarEstado(int id, String nuevoEstado) {

        Solicitudes solicitud = buscarPorId(id);

        if (solicitud != null) {

            if (nuevoEstado.equals("PENDIENTE")
                    || nuevoEstado.equals("EN_PROCESO")
                    || nuevoEstado.equals("APROBADA")
                    || nuevoEstado.equals("RECHAZADA")) {

                solicitud.setEstado(nuevoEstado);

                System.out.println("Estado actualizado correctamente.");

            } else {
                System.out.println("Estado no válido.");
            }

        } else {
            System.out.println("Solicitud no encontrada.");
        }
    }

    // Asignar un responsable
    public void asignarResponsable(
            int id,
            int idResponsable,
            String nombre,
            String area
    ) {

        Solicitudes solicitud = buscarPorId(id);

        if (solicitud != null) {

            Responsable responsable = new Responsable(
                    idResponsable,
                    nombre,
                    area
            );

            solicitud.setResponsable(responsable);

            System.out.println("Responsable asignado correctamente.");

        } else {
            System.out.println("Solicitud no encontrada.");
        }
    }

    // Buscar solicitudes por estado
    public void buscarPorEstado(String estado) {

        boolean encontrado = false;

        for (Solicitudes solicitud : solicitudes) {

            if (solicitud.getEstado().equals(estado)) {

                mostrarSolicitud(solicitud);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron solicitudes.");
        }
    }

    // Mostrar información de una solicitud
    public void mostrarSolicitud(Solicitudes solicitud) {

        System.out.println("----------------------------");
        System.out.println("ID: " + solicitud.getId());
        System.out.println("Estudiante: " + solicitud.getEstudiante().getNombre());
        System.out.println("Email: " + solicitud.getEstudiante().getEmail());
        System.out.println("Descripción: " + solicitud.getDescripcion());
        System.out.println("Tipo: " + solicitud.getTipo());
        System.out.println("Prioridad: " + solicitud.getPrioridad());
        System.out.println("Estado: " + solicitud.getEstado());

        if (solicitud.getResponsable() != null) {
            System.out.println("Responsable: "
                    + solicitud.getResponsable().getNombre());
            System.out.println("Área: "
                    + solicitud.getResponsable().getArea());
        } else {
            System.out.println("Responsable: Sin asignar");
        }

        System.out.println("----------------------------");
    }

    // Generar reporte general
    public void generarReporte() {

        int pendientes = 0;
        int enProceso = 0;
        int aprobadas = 0;
        int rechazadas = 0;

        for (Solicitudes solicitud : solicitudes) {

            if (solicitud.getEstado().equals("PENDIENTE")) {
                pendientes++;
            } else if (solicitud.getEstado().equals("EN_PROCESO")) {
                enProceso++;
            } else if (solicitud.getEstado().equals("APROBADA")) {
                aprobadas++;
            } else if (solicitud.getEstado().equals("RECHAZADA")) {
                rechazadas++;
            }
        }

        System.out.println("\n===== REPORTE DE SOLICITUDES =====");
        System.out.println("Total: " + solicitudes.size());
        System.out.println("Pendientes: " + pendientes);
        System.out.println("En proceso: " + enProceso);
        System.out.println("Aprobadas: " + aprobadas);
        System.out.println("Rechazadas: " + rechazadas);
    }
}