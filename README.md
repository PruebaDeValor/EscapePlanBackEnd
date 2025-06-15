# EscapePlan

EscapePlan es una aplicación para gestionar planes de Escape Room. Permite administrar personas, usuarios, roles, grupos de escape, salas, sesiones, encuestas, favoritos y relaciones entre personas y grupos.

## Tecnologías utilizadas

- **Java 24** (JDK 24.0.1)
- **Spring Boot 3.4.5**
- **Maven** para la gestión de dependencias
- **MySQL** como base de datos
- **Jakarta Validation** para validaciones de entidades
- **Spring Security** para autenticación y roles

---

## Configuración

Configura tu base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_escape_plan
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

---

## Endpoints de la API

### Personas (`/api/persons`)

| Método | Endpoint                | Descripción                                         |
|--------|-------------------------|-----------------------------------------------------|
| GET    | `/api/persons`          | Listar todas las personas.                          |
| GET    | `/api/persons/{id}`     | Obtener una persona por su ID.                      |
| GET    | `/api/persons/email/{email}` | Obtener una persona por su email.             |
| POST   | `/api/persons`          | Crear una nueva persona (email único y validado).   |
| PUT    | `/api/persons/{id}`     | Actualizar una persona existente.                   |
| DELETE | `/api/persons/{id}`     | Eliminar una persona por su ID.                     |

**Notas:**
- El campo `email` es obligatorio, debe ser válido y único.
- Si intentas crear una persona con un email ya registrado, se devuelve un error 400.

---

### Usuarios (`/api/users`)

| Método | Endpoint           | Descripción                                         |
|--------|--------------------|-----------------------------------------------------|
| GET    | `/api/users`       | Listar todos los usuarios.                          |
| POST   | `/api/users`       | Crear un nuevo usuario (username único y validado). |

**Notas:**
- El campo `username` es obligatorio, debe ser válido y único.
- El campo `password` se almacena cifrado.
- Al crear un usuario, se asigna el rol `ROLE_USER` por defecto y `ROLE_ADMIN` si el campo `admin` es `true`.
- Si intentas crear un usuario con un username ya registrado, se devuelve un error 400.

---

### Roles

- Los roles se gestionan automáticamente al crear usuarios.
- Puedes extender la API para exponer endpoints de roles si lo necesitas.

---

### Grupos de Escape (`/api/escapegroup`)

| Método | Endpoint               | Descripción                              |
|--------|------------------------|------------------------------------------|
| GET    | `/api/escapegroup`     | Listar todos los grupos de escape.       |
| GET    | `/api/escapegroup/{id}`| Obtener un grupo de escape por su ID.    |
| POST   | `/api/escapegroup`     | Crear un nuevo grupo de escape.          |
| PUT    | `/api/escapegroup/{id}`| Actualizar un grupo de escape existente. |
| DELETE | `/api/escapegroup/{id}`| Eliminar un grupo de escape por su ID.   |

---

### Favoritos de Escape (`/api/escapes/favourites`)

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

### Ubicaciones (`/api/locations`)

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/locations`   | Listar todas las ubicaciones.            |
| GET    | `/api/locations/{id}` | Obtener una ubicación por su ID.       |
| POST   | `/api/locations`   | Crear una nueva ubicación.               |
| PUT    | `/api/locations/{id}` | Actualizar una ubicación existente.    |
| DELETE | `/api/locations/{id}` | Eliminar una ubicación por su ID.      |

---

### Planes (`/api/plans`) *(estructura sugerida, implementar controlador)*

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/plans`       | Listar todos los planes.                 |
| GET    | `/api/plans/{id}`  | Obtener un plan por su ID.               |
| POST   | `/api/plans`       | Crear un nuevo plan.                     |
| PUT    | `/api/plans/{id}`  | Actualizar un plan existente.            |
| DELETE | `/api/plans/{id}`  | Eliminar un plan por su ID.              |

---

### Salas (`/api/rooms`) *(estructura sugerida, implementar controlador)*

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/rooms`       | Listar todas las salas.                  |
| GET    | `/api/rooms/{id}`  | Obtener una sala por su ID.              |
| POST   | `/api/rooms`       | Crear una nueva sala.                    |
| PUT    | `/api/rooms/{id}`  | Actualizar una sala existente.           |
| DELETE | `/api/rooms/{id}`  | Eliminar una sala por su ID.             |

---

### Sesiones (`/api/sessions`) *(estructura sugerida, implementar controlador)*

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/sessions`    | Listar todas las sesiones.               |
| GET    | `/api/sessions/{id}` | Obtener una sesión por su ID.           |
| POST   | `/api/sessions`    | Crear una nueva sesión.                  |
| PUT    | `/api/sessions/{id}` | Actualizar una sesión existente.        |
| DELETE | `/api/sessions/{id}` | Eliminar una sesión por su ID.          |

---

### Encuestas (`/api/surveys`) *(estructura sugerida, implementar controlador)*

| Método | Endpoint           | Descripción                              |
|--------|--------------------|------------------------------------------|
| GET    | `/api/surveys`     | Listar todas las encuestas.              |
| GET    | `/api/surveys/{id}`| Obtener una encuesta por su ID.          |
| POST   | `/api/surveys`     | Crear una nueva encuesta.                |
| PUT    | `/api/surveys/{id}`| Actualizar una encuesta existente.       |
| DELETE | `/api/surveys/{id}`| Eliminar una encuesta por su ID.         |

---

### PersonGroup (`/api/persongroups`) *(estructura sugerida, implementar controlador)*

| Método | Endpoint                                  | Descripción                                      |
|--------|------------------------------------------|--------------------------------------------------|
| GET    | `/api/persongroups/person/{personId}`     | Obtener todos los grupos de una persona.         |
| GET    | `/api/persongroups/group/{groupId}`       | Obtener todas las personas de un grupo.          |
| POST   | `/api/persongroups`                      | Crear una relación entre persona y grupo.        |
| DELETE | `/api/persongroups/person/{personId}/group/{groupId}` | Eliminar una relación entre persona y grupo. |

---

## Próximos pasos

- Implementar los controladores y servicios para las entidades Room, Session, Plan, Survey y PersonGroup.
- Añadir endpoints completos para encuestas (Survey), incluyendo creación, edición y votación.
- Mejorar la validación y el manejo de errores en todos los endpoints.
- Añadir pruebas unitarias e integradas para los endpoints y servicios.
- Documentar la API con Swagger/OpenAPI.
- Optimizar la gestión de relaciones y restricciones de unicidad en entidades clave.
- Añadir paginación y filtros en los listados principales.
- Mejorar la seguridad y autenticación de la API.

---

¿Quieres que te ayude a generar la estructura de algún controlador o endpoint que falte?