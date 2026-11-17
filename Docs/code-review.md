
# Code Review - Sistema de Gestión de Solicitudes Académicas

## 1. Objetivo

Evaluar la calidad del código refactorizado mediante una revisión técnica, identificando aspectos positivos, oportunidades de mejora y criterios de aceptación.

## 2. Checklist técnico

| N.º | Criterio | Resultado |
|---|---|---|
| 1 | El proyecto compila y ejecuta correctamente. | Cumple |
| 2 | Los nombres de clases, métodos y variables son descriptivos. | Cumple |
| 3 | Las clases tienen responsabilidades bien definidas. | Cumple |
| 4 | Se separa la lógica de negocio de la presentación. | Cumple |
| 5 | Se utilizan interfaces para reducir el acoplamiento. | Cumple |
| 6 | Se utilizan enums para estados, tipos y prioridades. | Cumple |
| 7 | Se controlan las entradas incorrectas del usuario. | Cumple |
| 8 | Se manejan las solicitudes inexistentes. | Cumple |
| 9 | Se evita la duplicación innecesaria de código. | Cumple |
| 10 | Las funcionalidades principales fueron probadas. | Cumple |
| 11 | Los métodos tienen una cantidad razonable de parámetros. | Cumple |
| 12 | Los datos se conservan durante la ejecución. | Cumple |

## 3. Observaciones

| N.º | Observación | Recomendación |
|---|---|---|
| 1 | MenuConsola concentra varias operaciones de interacción. | Mantener métodos pequeños y específicos. |
| 2 | El servicio utiliza excepciones para informar solicitudes inexistentes. | Mantener un manejo uniforme de errores. |
| 3 | El repositorio utiliza almacenamiento en memoria. | Incorporar persistencia en futuras versiones. |
| 4 | No existe un repositorio centralizado de estudiantes. | Evaluar su incorporación si el sistema crece. |
| 5 | Los identificadores se reinician al iniciar el programa. | Implementar identificación persistente en futuras versiones. |

## 4. Feedback profesional

### Aspectos positivos
- Mejor separación de responsabilidades.
- Incorporación de interfaces.
- Uso de enumeraciones.
- Simplificación de parámetros mediante DatosSolicitud.
- Pruebas funcionales satisfactorias.

### Oportunidades de mejora
- Incorporar persistencia de datos.
- Centralizar la administración de estudiantes.
- Mejorar la separación de consultas y reportes.
- Incorporar pruebas unitarias automatizadas.

## 5. Correcciones realizadas

| Problema inicial | Corrección |
|---|---|
| Main concentraba varias responsabilidades. | Se creó MenuConsola. |
| Lógica de negocio mezclada con presentación. | Se separaron servicio y menú. |
| Estados y prioridades representados como String. | Se incorporaron enums. |
| Exceso de parámetros. | Se creó DatosSolicitud. |
| Almacenamiento acoplado al servicio. | Se incorporó SolicitudRepository. |
| Validación insuficiente de entradas. | Se incorporó leerEntero(). |
| Solicitudes inexistentes sin manejo uniforme. | Se incorporó una excepción en el servicio. |

## 6. Criterios de aceptación técnica

| Criterio | Resultado |
|---|---|
| Compilación correcta | Cumple |
| Funcionalidades principales | Cumple |
| Aplicación de SOLID | Cumple |
| Buenas prácticas Clean Code | Cumple |
| Manejo de errores | Cumple |
| Pruebas funcionales | Cumple |
| Documentación | Pendiente de completar |
| Persistencia permanente | No implementada |

## 7. Conclusión

La revisión técnica permitió comprobar las mejoras realizadas en la estructura del proyecto, especialmente en la separación de responsabilidades, el desacoplamiento de componentes y la legibilidad del código.

Se considera que la versión refactorizada cumple con los criterios fundamentales establecidos para el prototipo. Se identifican como mejoras futuras la incorporación de persistencia, una gestión centralizada de estudiantes y pruebas unitarias automatizadas.
