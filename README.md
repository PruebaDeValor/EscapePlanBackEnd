# EscapePlan

EscapePlan es una aplicación para gestionar planes de Escape Room. Permite administrar personas, grupos de escape, salas, sesiones, encuestas, favoritos y relaciones entre personas y grupos.

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

### **Survey**
Base URL: `/api/surveys` (pendiente de implementación)

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/surveys`     | Obtener todas las encuestas.             |
| GET    | `/api/surveys/{id}`| Obtener una encuesta por su ID.          |
| POST   | `/api/surveys`     | Crear una nueva encuesta.                |
| PUT    | `/api/surveys/{id}`| Actualizar una encuesta existente.       |
| DELETE | `/api/surveys/{id}`| Eliminar una encuesta por su ID.         |

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

### **EscapeFavourite**
Base URL: `/api/escapes/favourites`

| Método | Endpoint                                      | Descripción                                                        |
|--------|-----------------------------------------------|--------------------------------------------------------------------|
| GET    | `/api/escapes/favourites`                     | Listar todas las relaciones de favoritos.                          |
| GET    | `/api/escapes/favourites/{id}`                | Obtener un favorito por su id.                                     |
| POST   | `/api/escapes/favourites`                     | Añadir un escape favorito para una persona.                        |
| DELETE | `/api/escapes/favourites/{id}`                | Eliminar un escape favorito por su id.                             |
| GET    | `/api/escapes/favourites/room/{escapeId}`     | Buscar favorito por id de room (devuelve uno o 404 si no existe).  |
| GET    | `/api/escapes/favourites/person/id={userId}`  | Listar todos los favoritos de una persona por su id.               |

**Notas:**  
- Si la persona no existe o no tiene favoritos, el endpoint devuelve una lista vacía.
- Si el favorito por room no existe, devuelve 404.

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

> **Notas de progreso:**  
> - Entidad Survey creada con opciones usando `@ElementCollection`.  
> - Añadidos endpoints y lógica para favoritos (EscapeFavourite).  
> - Falta implementar endpoints para encuestas, salas, sesiones, planes y relaciones intermedias.  
> - Pendiente añadir entidades para funcionalidades avanzadas.

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

- Implementar los controladores y servicios para las entidades Room, Session, Plan, Survey y PersonGroup.
- Añadir entidades y endpoints para favoritos y encuestas.
- Mejorar la validación y el manejo de errores.
- Crear pruebas unitarias e integradas para los endpoints.

---