
package UI;

import DTO.DatosSolicitud;
import model.*;
import service.SolicitudService;

import java.util.List;
import java.util.Scanner;

public class MenuConsola {

    private final SolicitudService servicio;
    private final Scanner scanner;

    public MenuConsola(SolicitudService servicio) {
        this.servicio = servicio;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarSolicitud();
                    break;
                case 2:
                    cambiarEstado();
                    break;
                case 3:
                    asignarResponsable();
                    break;
                case 4:
                    buscarPorEstado();
                    break;
                case 5:
                    generarReporte();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println("\n==================================");
        System.out.println(" GESTIÓN DE SOLICITUDES ACADÉMICAS");
        System.out.println("==================================");
        System.out.println("1. Registrar solicitud");
        System.out.println("2. Cambiar estado");
        System.out.println("3. Asignar responsable");
        System.out.println("4. Buscar solicitudes por estado");
        System.out.println("5. Generar reporte");
        System.out.println("0. Salir");
        System.out.println("==================================");
    }

    private void registrarSolicitud() {
        System.out.println("\n--- REGISTRAR SOLICITUD ---");

        int idEstudiante = leerEntero("ID del estudiante: ");

        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();

        try {
            System.out.println("Tipos: CERTIFICADO, EQUIVALENCIA, INSCRIPCION, RECLAMO");
            System.out.print("Tipo de solicitud: ");

            TipoSolicitud tipo = TipoSolicitud.valueOf(
                    scanner.nextLine().trim().toUpperCase()
            );

            System.out.println("Prioridades: BAJA, MEDIA, ALTA");
            System.out.print("Prioridad: ");

            Prioridad prioridad = Prioridad.valueOf(
                    scanner.nextLine().trim().toUpperCase()
            );

            // Agrupar los datos en un único objeto
            DatosSolicitud datos = new DatosSolicitud(
                    idEstudiante,
                    nombre,
                    email,
                    descripcion,
                    tipo,
                    prioridad
            );

            // Registrar la solicitud mediante el servicio
            servicio.registrarSolicitud(datos);

            System.out.println("Solicitud registrada correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: tipo o prioridad no válidos.");
        }
    }

    private void cambiarEstado() {
        System.out.println("\n--- CAMBIAR ESTADO ---");

        int id = leerEntero("ID de solicitud: ");

        try {
            System.out.println("Estados disponibles:");
            System.out.println("PENDIENTE, EN_PROCESO, APROBADA, RECHAZADA");

            System.out.print("Nuevo estado: ");

            EstadoSolicitud estado = EstadoSolicitud.valueOf(
                    scanner.nextLine().trim().toUpperCase()
            );

            servicio.cambiarEstado(id, estado);

            System.out.println("Estado actualizado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: solicitud inexistente o estado inválido.");
        }
    }

    private void asignarResponsable() {
        System.out.println("\n--- ASIGNAR RESPONSABLE ---");

        int idSolicitud = leerEntero("ID de solicitud: ");
        int idResponsable = leerEntero("ID del responsable: ");

        System.out.print("Nombre del responsable: ");
        String nombre = scanner.nextLine();

        System.out.print("Área: ");
        String area = scanner.nextLine();

        try {
            Responsable responsable = new Responsable(
                    idResponsable, nombre, area
            );

            servicio.asignarResponsable(idSolicitud, responsable);

            System.out.println("Responsable asignado correctamente.");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarPorEstado() {
        System.out.println("\n--- BUSCAR POR ESTADO ---");

        try {
            System.out.println("Estados: PENDIENTE, EN_PROCESO, APROBADA, RECHAZADA");
            System.out.print("Ingrese estado: ");

            EstadoSolicitud estado = EstadoSolicitud.valueOf(
                    scanner.nextLine().trim().toUpperCase()
            );

            List<Solicitudes> solicitudes = servicio.obtenerSolicitudes();

            boolean encontrado = false;

            for (Solicitudes solicitud : solicitudes) {
                if (solicitud.getEstado() == estado) {
                    mostrarSolicitud(solicitud);
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron solicitudes.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Estado no válido.");
        }
    }

    private void generarReporte() {
        System.out.println("\n--- REPORTE DE SOLICITUDES ---");

        List<Solicitudes> solicitudes = servicio.obtenerSolicitudes();

        int pendientes = 0;
        int enProceso = 0;
        int aprobadas = 0;
        int rechazadas = 0;

        for (Solicitudes solicitud : solicitudes) {

            switch (solicitud.getEstado()) {
                case PENDIENTE:
                    pendientes++;
                    break;
                case EN_PROCESO:
                    enProceso++;
                    break;
                case APROBADA:
                    aprobadas++;
                    break;
                case RECHAZADA:
                    rechazadas++;
                    break;
            }
        }

        System.out.println("Total: " + solicitudes.size());
        System.out.println("Pendientes: " + pendientes);
        System.out.println("En proceso: " + enProceso);
        System.out.println("Aprobadas: " + aprobadas);
        System.out.println("Rechazadas: " + rechazadas);
    }

    private void mostrarSolicitud(Solicitudes solicitud) {
        System.out.println("\n------------------------------");
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

        System.out.println("------------------------------");
    }

    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }
}
