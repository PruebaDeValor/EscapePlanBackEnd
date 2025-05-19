# EscapePlan

EscapePlan es una aplicación para gestionar planes de Escape Room. Permite administrar personas, grupos de escape, salas, sesiones y relaciones entre personas y grupos.

## Tecnologías utilizadas

- **Java 24** (JDK 24.0.1)
- **Spring Boot 3.4.5**
- **Maven** para la gestión de dependencias
- **MySQL** como base de datos
- **Jakarta Validation** para validaciones de entidades

---

## Endpoints de la API

### **Person**
Base URL: `/api/persons`

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/persons`     | Obtener todas las personas.              |
| GET    | `/api/persons/{id}`| Obtener una persona por su ID.           |
| POST   | `/api/persons`     | Crear una nueva persona.                 |
| PUT    | `/api/persons/{id}`| Actualizar una persona existente.        |
| DELETE | `/api/persons/{id}`| Eliminar una persona por su ID.          |

---

### **EscapeGroup**
Base URL: `/api/escapegroup`

| Método | Endpoint               | Descripción                              |
|--------|------------------------|------------------------------------------|
| GET    | `/api/escapegroup`     | Obtener todos los grupos de escape.      |
| GET    | `/api/escapegroup/{id}`| Obtener un grupo de escape por su ID.    |
| POST   | `/api/escapegroup`     | Crear un nuevo grupo de escape.          |
| PUT    | `/api/escapegroup/{id}`| Actualizar un grupo de escape existente. |
| DELETE | `/api/escapegroup/{id}`| Eliminar un grupo de escape por su ID.   |

---

### **Location**
Base URL: `/api/locations`

| Método | Endpoint             | Descripción                              |
|--------|----------------------|------------------------------------------|
| GET    | `/api/locations`     | Obtener todas las ubicaciones.           |
| GET    | `/api/locations/{id}`| Obtener una ubicación por su ID.         |
| POST   | `/api/locations`     | Crear una nueva ubicación.               |
| PUT    | `/api/locations/{id}`| Actualizar una ubicación existente.      |
| DELETE | `/api/locations/{id}`| Eliminar una ubicación por su ID.        |

---

### **Room**
Base URL: `/api/rooms` (pendiente de implementación)

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/rooms`       | Obtener todas las salas de escape.       |
| GET    | `/api/rooms/{id}`  | Obtener una sala de escape por su ID.    |
| POST   | `/api/rooms`       | Crear una nueva sala de escape.          |
| PUT    | `/api/rooms/{id}`  | Actualizar una sala de escape existente. |
| DELETE | `/api/rooms/{id}`  | Eliminar una sala de escape por su ID.   |

---

### **Session**
Base URL: `/api/sessions` (pendiente de implementación)

| Método | Endpoint             | Descripción                              |
|--------|----------------------|------------------------------------------|
| GET    | `/api/sessions`      | Obtener todas las sesiones.              |
| GET    | `/api/sessions/{id}` | Obtener una sesión por su ID.            |
| POST   | `/api/sessions`      | Crear una nueva sesión.                  |
| PUT    | `/api/sessions/{id}` | Actualizar una sesión existente.         |
| DELETE | `/api/sessions/{id}` | Eliminar una sesión por su ID.           |

---

### **Plan**
Base URL: `/api/plans` (pendiente de implementación)

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/plans`       | Obtener todos los planes.                |
| GET    | `/api/plans/{id}`  | Obtener un plan por su ID.               |
| POST   | `/api/plans`       | Crear un nuevo plan.                     |
| PUT    | `/api/plans/{id}`  | Actualizar un plan existente.            |
| DELETE | `/api/plans/{id}`  | Eliminar un plan por su ID.              |

---

### **PersonGroup**
Base URL: `/api/persongroups` (pendiente de implementación)

| Método | Endpoint                                  | Descripción                                      |
|--------|------------------------------------------|--------------------------------------------------|
| GET    | `/api/persongroups/person/{personId}`     | Obtener todos los grupos de una persona.         |
| GET    | `/api/persongroups/group/{groupId}`       | Obtener todas las personas de un grupo.          |
| POST   | `/api/persongroups`                      | Crear una relación entre persona y grupo.        |
| DELETE | `/api/persongroups/person/{personId}/group/{groupId}` | Eliminar una relación entre persona y grupo. |

---

> **Nos faltan entities para favoritos, quiero hacer y encuestas**

---

## Configuración del proyecto

### **Base de datos**
El proyecto utiliza MySQL como base de datos. Asegúrate de configurar las credenciales en el archivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/escapeplan
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

---

## Próximos pasos

- Implementar los controladores y servicios para las entidades Room, Session, Plan y PersonGroup.
- Añadir entidades y endpoints para favoritos y encuestas.
- Mejorar la validación y el manejo de errores.
- Crear pruebas unitarias e integradas para los endpoints.

---
````---

## Próximos pasos

- Implementar los controladores y servicios para las entidades Room, Session, Plan y PersonGroup.
- Añadir entidades y endpoints para favoritos y encuestas.
- Mejorar la validación y el manejo de errores.
- Crear pruebas unitarias e integradas para los endpoints.

---