package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.PersonService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controlador REST para la entidad Person.
 * Proporciona endpoints para gestionar personas.
 **/
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.UserService userService;

    // Buscar todas las personas
    @GetMapping
        @Operation(summary = "Listar todas las personas", description = "Devuelve todas las personas registradas")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Lista de personas",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "[{\"id\": 1, \"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}]")
                )
            )
        })
    public List<Person> list() {
        return personService.findAll();
    }

    // Buscar una persona por ID
    @GetMapping("/{id}")
        @Operation(summary = "Obtener persona por ID", description = "Devuelve una persona específica por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Persona encontrada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Persona no encontrada",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"Person with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if(personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para buscar una persona por email
    @GetMapping("/email/{email}")
        @Operation(summary = "Buscar persona por email", description = "Devuelve una persona específica por su email")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Persona encontrada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Persona no encontrada",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"Person with email juan@example.com does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Optional<Person> personOptional = personService.findByEmail(email);
        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva persona validando el email
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
        @Operation(summary = "Crear nueva persona", description = "Crea una nueva persona validando el email")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Persona creada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Email ya registrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"El email ya está registrado.\"}")
                )
            )
        })
    public ResponseEntity<?> create(@Valid @RequestBody Person person) {
        // Comprobar si ya existe una persona con ese email
        Optional<Person> existing = personService.findByEmail(person.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está registrado.");
        }
        Person personNew = personService.save(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(personNew);
    }
    // Crear una nueva persona validando el email y asociándola a un usuario
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/user/{userId}")
        @Operation(summary = "Crear persona y asociar a usuario", description = "Crea una nueva persona y la asocia a un usuario existente")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Persona creada y asociada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Email ya registrado o usuario no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"El email ya está registrado.\"}")
                )
            )
        })
    public ResponseEntity<?> createAndAssignToUser(@PathVariable Long userId, @Valid @RequestBody Person person) {
        // Validación de email único
        Optional<Person> existing = personService.findByEmail(person.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.badRequest().body("El email ya está registrado.");
        }

        // Buscar el usuario
        Optional<User> userOpt = userService.findById(userId);
        if (userOpt.isEmpty()) {
        return ResponseEntity.badRequest().body("Usuario no encontrado.");
        }
        User user = userOpt.get();

        // Asociar la persona al usuario
        person = personService.save(person);
        user.setPerson(person);
        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(person);
    }
    
    // Actualizar una persona existente
    @PutMapping("/{id}")
        @Operation(summary = "Actualizar persona", description = "Actualiza los datos de una persona existente")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Persona actualizada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            )
        })
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    // Eliminar una persona por ID
    @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar persona por ID", description = "Elimina una persona específica por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Persona eliminada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Person.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Juan Pérez\", \"email\": \"juan@example.com\"}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Persona no encontrada",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"Person with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Person person = new Person();
        person.setId(id);
        Optional<Person> personOptional = personService.delete(person);
        if(personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
