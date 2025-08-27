package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.UserService;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository personRepository;

    //LISTAR USUARIOS
    @Operation(
        summary = "Obtener todos los usuarios",
        description = "Devuelve la lista de todos los usuarios registrados en el sistema."
    )
    @ApiResponse(
        responseCode = "200",
        description = "Lista de usuarios obtenida correctamente",
        content = @Content(
            mediaType = "application/json",
            schema = @Schema(implementation = User.class)
        )
    )
    @GetMapping
    public List<User> list() {
        return service.findAll();
    }


    //CREAR USUARIOS
    @Operation(
        summary = "Crear un nuevo usuario por un admin (puede ser admin el usuario)",
        description = "Permite crear un usuario. Solo accesible para administradores."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuario creado correctamente",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = User.class),
                examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "username": "admin",
                      "password": "hashedPassword",
                      "email": "admin@example.com",
                      "admin": true
                    }
                """)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "Datos del usuario a crear",
                required = true,
                content = @Content(
                    schema = @Schema(implementation = User.class),
                    examples = @ExampleObject(value = """
                        {
                          "username": "nuevoUsuario",
                          "password": "123456",
                          "email": "nuevo@example.com",
                          "admin": false
                        }
                    """)
                )
            )
            @Valid @RequestBody User user,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    //ACTUALIZAR USUARIOS
    @Operation(
        summary = "Actualizar un usuario existente",
        description = "Modifica los datos de un usuario existente por ID."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuario actualizado correctamente",
            content = @Content(
                schema = @Schema(implementation = User.class),
                examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "username": "usuarioEditado",
                      "password": "nuevaPassword",
                      "email": "editado@example.com",
                      "admin": false
                    }
                """)
            )
        ),
        @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Parameter(description = "ID del usuario a actualizar", example = "1") @PathVariable Long id,
            @RequestBody User user) {
        user.setId(id);
        User userUpdated = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUpdated);
    }

    //Asignar una persona a un usuario
    @Operation(
        summary = "Asignar una persona a un usuario",
        description = "Asocia una entidad Persona a un usuario existente."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Persona asignada correctamente",
            content = @Content(
                schema = @Schema(implementation = User.class),
                examples = @ExampleObject(value = """
                    {
                      "id": 1,
                      "username": "usuario1",
                      "email": "usuario1@example.com",
                      "admin": false,
                      "person": {
                        "id": 3,
                        "name": "Juan Pérez",
                        "birthDate": "1990-05-20"
                      }
                    }
                """)
            )
        ),
        @ApiResponse(responseCode = "404", description = "Usuario o persona no encontrados")
    })
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{userId}/person/{personId}")
    public ResponseEntity<?> assignPersonToUser(
            @Parameter(description = "ID del usuario", example = "1") @PathVariable Long userId,
            @Parameter(description = "ID de la persona", example = "3") @PathVariable Long personId) {

        User user = service.findById(userId)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Person person = personRepository.findById(personId)
            .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        user.setPerson(person);
        User updatedUser = service.save(user);

        return ResponseEntity.ok(updatedUser);
    }

    //REGISTRAR USUARIO Y QUE ESTE SEA AUTOMATICAMENTE UN ROL USER
    @Operation(
        summary = "Registrar un nuevo usuario con rol user",
        description = "Permite el registro de un usuario con rol por defecto (no administrador)."
    )
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Usuario registrado correctamente",
            content = @Content(
                schema = @Schema(implementation = User.class),
                examples = @ExampleObject(value = """
                    {
                      "id": 2,
                      "username": "usuarioRegistrado",
                      "email": "nuevo@example.com",
                      "admin": false
                    }
                """)
            )
        ),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping("/register")
    public ResponseEntity<?> register(
            @Valid @RequestBody User user,
            BindingResult result) {
        user.setAdmin(false);
        return create(user, result);
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}