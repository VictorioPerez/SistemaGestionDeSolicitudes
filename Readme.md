# Sistema de Gestión de Solicitudes Académicas

## Descripción del proyecto

El Sistema de Gestión de Solicitudes Académicas es una aplicación desarrollada en Java que permite administrar los trámites académicos realizados por estudiantes dentro de una institución educativa.

El proyecto tiene como objetivo facilitar el registro, seguimiento y administración de solicitudes, permitiendo organizar la información según su tipo, prioridad y estado.

Esta aplicación fue desarrollada como parte de un Trabajo Práctico Integrador, cuyo propósito es analizar y mejorar la calidad interna de un sistema mediante la aplicación de principios SOLID, buenas prácticas de Clean Code y técnicas de refactorización.

## Funcionalidades

El sistema cuenta con las siguientes funcionalidades:

- **Registrar solicitudes:** permite ingresar los datos del estudiante y crear una nueva solicitud académica.
- **Cambiar estado:** permite actualizar el estado de una solicitud.
- **Asignar responsable:** permite asociar un responsable y un área a una solicitud.
- **Buscar por estado:** permite consultar las solicitudes según su estado actual.
- **Generar reportes:** muestra la cantidad total de solicitudes y su distribución por estado.
- **Validación de entradas:** controla los datos ingresados por el usuario y contempla situaciones de error.

### Estados disponibles

- PENDIENTE
- EN_PROCESO
- APROBADA
- RECHAZADA

### Tipos de solicitudes

- CERTIFICADO
- EQUIVALENCIA
- INSCRIPCION
- RECLAMO

### Niveles de prioridad

- BAJA
- MEDIA
- ALTA

## Tecnologías utilizadas

- **Java:** lenguaje de programación utilizado para desarrollar la aplicación.
- **Programación Orientada a Objetos:** organización del sistema mediante clases y objetos.
- **Git:** herramienta de control de versiones.
- **GitHub:** plataforma utilizada para almacenar y gestionar el repositorio.
- **IntelliJ IDEA:** entorno de desarrollo utilizado para implementar y ejecutar el proyecto.

## Estructura del proyecto

```text
GestionSolicitudesAcademicas/
│
├── src/
│   ├── model/
│   │   ├── Estudiante.java
│   │   ├── Responsable.java
│   │   ├── Solicitudes.java
│   │   ├── EstadoSolicitud.java
│   │   ├── TipoSolicitud.java
│   │   └── Prioridad.java
│   │
│   ├── DTO/
│   │   └── DatosSolicitud.java
│   │
│   ├── repository/
│   │   ├── SolicitudRepository.java
│   │   └── InMemorySolicitudRepository.java
│   │
│   ├── service/
│   │   └── SolicitudService.java
│   │
│   ├── ui/
│   │   └── MenuConsola.java
│   │
│   └── Main.java
│
├── docs/
│   ├── code-review.md
│
└── README.md
```

## Instalación y ejecución

### Requisitos previos

- Tener instalado Java JDK.
- Contar con IntelliJ IDEA u otro entorno compatible con Java.
- Tener Git instalado para clonar el repositorio.

### Clonar el repositorio

```bash
git clone URL_DEL_REPOSITORIO
```

Reemplazar `URL_DEL_REPOSITORIO` por la dirección del repositorio de GitHub.

### Abrir el proyecto

1. Abrir IntelliJ IDEA.
2. Seleccionar la opción **Open**.
3. Elegir la carpeta del proyecto descargado.
4. Configurar el JDK correspondiente.
5. Esperar a que el IDE reconozca los paquetes y archivos Java.

### Ejecutar la aplicación

Localizar el archivo `Main.java` dentro de `src` y ejecutar el método `main()`.

La aplicación mostrará un menú interactivo de consola desde el cual se podrá acceder a las diferentes funcionalidades.

## Arquitectura y organización

El proyecto utiliza una separación por responsabilidades:

- **Model:** contiene las entidades principales y las enumeraciones del sistema.
- **DTO:** agrupa los datos necesarios para registrar solicitudes.
- **Repository:** define las operaciones de almacenamiento y su implementación.
- **Service:** contiene la lógica y las operaciones del negocio.
- **UI:** administra la interacción con el usuario mediante la consola.
- **Main:** inicializa y conecta los componentes de la aplicación.

## Calidad y refactorización

Durante el desarrollo se realizó un análisis de calidad del código inicial y se aplicaron mejoras utilizando:

- **SRP:** separación de responsabilidades entre los componentes.
- **OCP:** utilización de abstracciones para facilitar extensiones.
- **DIP:** dependencia de interfaces en lugar de implementaciones concretas.
- **Clean Code:** nombres descriptivos, métodos organizados y manejo de errores.
- **Extract Method:** extracción de funcionalidades en métodos específicos.
- **Move Method:** reubicación de responsabilidades.
- **Introduce Parameter Object:** agrupación de parámetros mediante `DatosSolicitud`.
- **Replace Primitive with Enum:** reemplazo de cadenas de texto por enumeraciones.

También se realizaron pruebas funcionales para verificar que las modificaciones no alteraran negativamente el comportamiento externo del sistema.

## Almacenamiento de datos

La aplicación utiliza `InMemorySolicitudRepository` para almacenar las solicitudes en una colección en memoria.

Los datos permanecen disponibles durante la ejecución del programa, pero se pierden al cerrarlo. No se utiliza una base de datos externa.

## Documentación

Dentro de la carpeta `docs` se encuentra la documentación complementaria del proyecto:

- Checklist de revisión de código.
- Decisiones técnicas.


## Autoría

Trabajo Práctico Integrador – Calidad y Mantenimiento de Software.

Proyecto desarrollado con Java.