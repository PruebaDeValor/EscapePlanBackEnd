# EscapePlan (prubadevalor-escapes)

Backend para gestión de planes de Escape Room, usuarios, grupos, salas, sesiones, encuestas y favoritos.  
Desarrollado en **Spring Boot 3**, con autenticación JWT, roles, validaciones y arquitectura en capas.

---

## Tabla de Contenidos

- [Tecnologías](#tecnologías)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Configuración](#configuración)
- [Seguridad y Autenticación](#seguridad-y-autenticación)
- [CORS](#cors)
- [Principales Endpoints](#principales-endpoints)
- [Relaciones entre entidades](#relaciones-entre-entidades)
- [Ejemplos de uso de endpoints](#ejemplos-de-uso-de-endpoints)
- [Recomendaciones para frontend y app móvil](#recomendaciones-para-frontend-y-app-móvil)
- [Próximos pasos y mejoras](#próximos-pasos-y-mejoras)

---

## Tecnologías

- **Java 24**
- **Spring Boot 3.4.5**
- **Spring Security (JWT)**
- **MySQL**
- **Maven**
- **Jakarta Validation**
- **JUnit** para tests

---

## Estructura del Proyecto

```
src/
 └── main/
     ├── java/com/pruebadevalor/quedadas/escapes/prubadevalor_escapes/
     │    ├── controllers/   # Controladores REST
     │    ├── entities/      # Entidades JPA
     │    ├── repositories/  # Acceso a datos
     │    ├── security/      # Configuración de seguridad y filtros JWT
     │    ├── services/      # Lógica de negocio
     │    └── validation/    # Validaciones personalizadas
     └── resources/
          ├── application.properties
          └── import.sql
```

---

## Configuración

Configura tu base de datos en `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_escape_plan
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

- **Roles iniciales:**  
  Asegúrate de tener los roles `ROLE_USER` y `ROLE_ADMIN` en la tabla `roles`.

---

## Seguridad y Autenticación

- **JWT:**  
  El backend emite y valida tokens JWT para proteger los endpoints.
- **Roles:**  
  Soporta roles `ROLE_USER` y `ROLE_ADMIN` para autorización granular.
- **Contraseñas:**  
  Se almacenan cifradas con BCrypt.
- **Endpoints públicos:**  
  Registro y login de usuario.
- **Endpoints protegidos:**  
  Requieren JWT en la cabecera `Authorization: Bearer <token>`.

---

## CORS

- **Configurado para permitir todos los orígenes en desarrollo** (`*`).
- Para producción, modifica en `SpringSecurityConfig.java` los orígenes permitidos.

---

## Principales Endpoints

### Usuarios (`/api/users`)

| Método | Endpoint           | Descripción                                         |
|--------|--------------------|-----------------------------------------------------|
| GET    | `/api/users`       | Listar usuarios.                                    |
| POST   | `/api/users`       | Crear usuario (username único, password cifrada).   |
| POST   | `/api/users/login` | Login y obtención de JWT.                           |

---

### Personas (`/api/persons`)

| Método | Endpoint                        | Descripción                                         |
|--------|---------------------------------|-----------------------------------------------------|
| GET    | `/api/persons`                  | Listar personas.                                    |
| GET    | `/api/persons/{id}`             | Obtener persona por ID.                             |
| GET    | `/api/persons/email/{email}`    | Buscar persona por email.                           |
| POST   | `/api/persons`                  | Crear persona (email único y validado).             |
| POST   | `/api/persons/user/{userId}`    | Crear persona y asociarla a un usuario existente.   |
| PUT    | `/api/persons/{id}`             | Actualizar persona.                                 |
| DELETE | `/api/persons/{id}`             | Eliminar persona.                                   |

---

### Asociaciones User-Person

- **Relación 1:1**:  
  Un usuario puede tener asociada una persona y viceversa.
- Puedes crear una persona y luego asociarla a un usuario, o crearla directamente asociada con `/api/persons/user/{userId}`.

---

### Otros recursos

- **Grupos de Escape:** `/api/escapegroup`
- **Favoritos de Escape:** `/api/escapes/favourites`
- **Ubicaciones:** `/api/locations`
- **Salas:** `/api/rooms`
- **Planes:** `/api/plans`
- **Sesiones:** `/api/sessions`
- **Encuestas:** `/api/surveys`
- **PersonGroup:** `/api/persongroups`

*(Ver código para endpoints detallados y estructura de cada entidad)*

---

## Relaciones entre entidades

- **User** 1:1 **Person**
- **User** n:m **Role**
- **Person** n:m **EscapeGroup** (a través de PersonGroup)
- **Person** n:m **EscapeFavourite**
- **EscapeGroup** 1:n **PersonGroup**
- **Plan**, **Session**, **Survey**: ver entidades y controladores

---

## Ejemplos de uso de endpoints

### Registro de usuario

**POST** `/api/users`
```json
{
  "username": "usuario1",
  "password": "clave1234",
  "admin": false
}
```

### Login de usuario

**POST** `/api/users/login`
```json
{
  "username": "usuario1",
  "password": "clave1234"
}
```
**Respuesta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### Crear persona y asociarla a un usuario

**POST** `/api/persons/user/1`
```json
{
  "firstName": "Juan",
  "lastName": "Pérez",
  "email": "juan@email.com",
  "birthDate": "1990-01-01",
  "isPremium": true
}
```

### Acceso a endpoints protegidos

Incluye el JWT en la cabecera:
```
Authorization: Bearer <token>
```

---

## Recomendaciones para frontend y app móvil

- **Web:**  
  - Usa fetch/axios para consumir la API.
  - Guarda el JWT en memoria o en almacenamiento seguro (no en localStorage si puedes evitarlo).
  - Añade el JWT en la cabecera `Authorization` en cada petición protegida.
- **Android:**  
  - Usa Retrofit, Volley o HttpUrlConnection para consumir la API.
  - Guarda el JWT en SharedPreferences seguro.
  - Añade el JWT en la cabecera `Authorization` en cada petición protegida.
- **CORS:**  
  - Si tienes errores de CORS en desarrollo, revisa la configuración en `SpringSecurityConfig.java`.

---

## Próximos pasos y mejoras

- Implementar controladores completos para Room, Session, Plan, Survey y PersonGroup.
- Añadir documentación Swagger/OpenAPI.
- Mejorar validaciones y manejo de errores.
- Añadir paginación y filtros en listados.
- Añadir tests unitarios e integrados.
- Optimizar la gestión de relaciones y restricciones de unicidad.
- Revisar la consistencia de los deletes (borrado en cascada, FK).
- Restringir CORS para producción.

---

**¿Dudas o sugerencias?**  
Abre un issue en el repositorio o contacta con el autor.
