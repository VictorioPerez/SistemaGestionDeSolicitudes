import model.Solicitudes;
import service.SistemaSolicitudes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SistemaSolicitudes sistema = new SistemaSolicitudes();

        int opcion;

        do {

            System.out.println("\n===== GESTIÓN DE SOLICITUDES ACADÉMICAS =====");
            System.out.println("1. Registrar solicitud");
            System.out.println("2. Cambiar estado");
            System.out.println("3. Asignar responsable");
            System.out.println("4. Buscar solicitudes por estado");
            System.out.println("5. Generar reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("\n--- REGISTRAR SOLICITUD ---");

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();

                    System.out.print("Tipo (CERTIFICADO, EQUIVALENCIA, INSCRIPCION, RECLAMO): ");
                    String tipo = scanner.nextLine().toUpperCase();

                    System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
                    String prioridad = scanner.nextLine().toUpperCase();

                    sistema.registrarSolicitud(
                            id,
                            nombre,
                            email,
                            descripcion,
                            tipo,
                            prioridad
                    );

                    break;

                case 2:

                    System.out.println("\n--- CAMBIAR ESTADO ---");

                    System.out.print("ID de solicitud: ");
                    int idEstado = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nuevo estado (PENDIENTE, EN_PROCESO, APROBADA, RECHAZADA): ");
                    String estado = scanner.nextLine().toUpperCase();

                    sistema.cambiarEstado(idEstado, estado);

                    break;

                case 3:

                    System.out.println("\n--- ASIGNAR RESPONSABLE ---");

                    System.out.print("ID de solicitud: ");
                    int idSolicitud = scanner.nextInt();

                    System.out.print("ID del responsable: ");
                    int idResponsable = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nombre del responsable: ");
                    String nombreResponsable = scanner.nextLine();

                    System.out.print("Área: ");
                    String area = scanner.nextLine();

                    sistema.asignarResponsable(
                            idSolicitud,
                            idResponsable,
                            nombreResponsable,
                            area
                    );

                    break;

                case 4:

                    System.out.println("\n--- BUSCAR POR ESTADO ---");

                    System.out.print("Ingrese estado: ");
                    String estadoBusqueda = scanner.nextLine().toUpperCase();

                    sistema.buscarPorEstado(estadoBusqueda);

                    break;

                case 5:

                    sistema.generarReporte();

                    break;

                case 0:

                    System.out.println("Saliendo del sistema...");

                    break;

                default:

                    System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}