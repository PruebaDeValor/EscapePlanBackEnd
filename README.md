
# EscapePlan (prubadevalor-escapes)

Backend para gestión de planes de Escape Room, usuarios, grupos, salas, sesiones, encuestas y favoritos.  
Desarrollado en **Spring Boot 3**, con autenticación JWT, roles, validaciones y arquitectura en capas.

---


## Tabla de Contenidos

- [Tecnologías](#tecnologías)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Documentación de la API (Swagger)](#documentación-de-la-api-swagger)
- [Configuración](#configuración)
- [Seguridad y Autenticación](#seguridad-y-autenticación)
- [CORS](#cors)
- [Relaciones entre entidades](#relaciones-entre-entidades)
- [Ejemplos de uso de endpoints](#ejemplos-de-uso-de-endpoints)


---

## Tecnologías

- **Java 21**
- **Spring Boot 3.4.5**
- **Spring Security (JWT)**
- **MySQL**
- **Maven**
- **Jakarta Validation**

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
     └── 
```

---


## Documentación de la API (Swagger)

La documentación completa y actualizada de los endpoints está disponible en Swagger/OpenAPI.

- Accede a la documentación interactiva en http://ec2-16-171-36-97.eu-north-1.compute.amazonaws.com:8080/swagger-ui/index.html#/
- Incluye detalles de cada endpoint, parámetros, respuestas y ejemplos.
- Consulta aquí la información más actualizada sobre la API, evitando duplicidad y desactualización.

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


## Relaciones entre entidades

Revisar Swagger

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


### Acceso a endpoints protegidos

Incluye el JWT en la cabecera:
```
Authorization: Bearer <token>
```

---



=======


