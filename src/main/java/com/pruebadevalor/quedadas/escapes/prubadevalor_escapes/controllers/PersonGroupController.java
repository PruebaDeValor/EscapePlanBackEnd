package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.PersonGroupRequestDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.PersonGroupService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/persongroups")
// Controlador REST para la entidad PersonGroup.
// Proporciona endpoints para gestionar relaciones entre grupos y personas.
public class PersonGroupController {

    @Autowired
    private PersonGroupService personGroupService;

    // Buscar todas las relaciones entre personas y grupos
    @GetMapping
    @Operation(summary = "Listar todas las relaciones", description = "Devuelve todas las relaciones entre personas y grupos de escape")
    public List<PersonGroup> list() {
        return personGroupService.findAll();
    }

    // Buscar relaciones por ID de PersonGroup
    // Endpoint: GET /api/persongroups/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener relación por ID", description = "Devuelve una relación específica por su ID")
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "200",
            description = "Relación encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = PersonGroup.class),
                examples = @ExampleObject(
                    value = "{\n  \"id\": 5,\n  \"person\": {\"id\": 1},\n  \"escapeGroup\": {\"id\": 2},\n  \"role\": \"MEMBER\",\n  \"status\": \"ACTIVE\"\n}"
                )
            )
        ),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "404",
            description = "Relación no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = "{\"error\": \"PersonGroup with id 5 does not exist.\"}"
                )
            )
        )
    })
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<PersonGroup> personGroupOptional = personGroupService.findById(id);
        if (personGroupOptional.isPresent()) {
            return ResponseEntity.ok(personGroupOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar relaciones por ID de persona y grupo de escape
    @GetMapping("/person/{personId}/escapegroup/{escapeGroupId}")
        @Operation(summary = "Buscar relación por ID de persona y grupo de escape", description = "Devuelve la relación entre una persona y un grupo de escape por sus IDs")
    public ResponseEntity<?> findByPersonIdAndEscapeGroupId(@PathVariable Long personId, @PathVariable Long escapeGroupId) {
        Optional<PersonGroup> personGroupOptional = personGroupService.findByPersonIdAndEscapeGroupId(personId, escapeGroupId);
        if (personGroupOptional.isPresent()) {
            return ResponseEntity.ok(personGroupOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Guardar una nueva relación entre persona y grupo de escape con rol y status
    @PostMapping("/person/{personId}/escapegroup/{escapeGroupId}")
        @Operation(summary = "Crear relación entre persona y grupo de escape con rol y estado", description = "Crea una nueva relación entre persona y grupo de escape especificando el rol y el estado")
    public ResponseEntity<PersonGroup> create(@PathVariable Long personId, @PathVariable Long escapeGroupId,
                                              @RequestBody PersonGroupRequestDto request) {
        PersonGroup savedPersonGroup = personGroupService.saveByPersonIdEscapeGroupIdRoleAndStatus(
                personId, escapeGroupId, request.role, request.status);
        if (savedPersonGroup == null) {
            return ResponseEntity.badRequest().build();
        }
        // Retorna el objeto guardado con un código de estado 201 (CREATED)
        return ResponseEntity.status(201).body(savedPersonGroup);
    }

    // Buscar todas las relaciones de una persona por su ID
    @GetMapping("/person/{personId}")
    @Operation(summary = "Listar relaciones por ID de persona", description = "Devuelve todas las relaciones de una persona por su ID")
public ResponseEntity<List<PersonGroup>> findAllByPersonId(@PathVariable Long personId) {
    List<PersonGroup> result = personGroupService.findAllByPersonId(personId);
    if (result.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(result);
    }

    // Buscar todas las personas relacionadas con un grupo de escape por el id del grupo
    @GetMapping("/escapegroup/{escapeGroupId}")
        @Operation(summary = "Listar relaciones por ID de grupo de escape", description = "Devuelve todas las relaciones de personas asociadas a un grupo de escape por su ID")
    public ResponseEntity<List<PersonGroup>> findByEscapeGroupId(@PathVariable Long escapeGroupId) {
        List<PersonGroup> result = personGroupService.findByEscapeGroupId(escapeGroupId);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    // Agregar un nuevo PersonGroup
    @PostMapping
    @Operation(summary = "Crear relación entre persona y grupo", description = "Crea una nueva relación entre persona y grupo de escape")
    @io.swagger.v3.oas.annotations.responses.ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "201",
            description = "Relación creada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = PersonGroup.class),
                examples = @ExampleObject(
                    value = "{\n  \"person\": {\"id\": 1},\n  \"escapeGroup\": {\"id\": 2},\n  \"role\": \"MEMBER\",\n  \"status\": \"ACTIVE\"\n}"
                )
            )
        ),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(
            responseCode = "400",
            description = "Datos inválidos",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                    value = "{\"error\": \"This person is already in the group.\"}"
                )
            )
        )
    })
    public ResponseEntity<?> create(@Valid @RequestBody PersonGroup personGroup, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        // (Opcional) Validar que no exista ya esa relación
        boolean exists = personGroupService
            .findByPersonIdAndEscapeGroupId(personGroup.getPerson().getId(), personGroup.getEscapeGroup().getId())
            .isPresent();
        if (exists) {
            return ResponseEntity.badRequest().body("This person is already in the group.");
        }
        PersonGroup savedPersonGroup = personGroupService.save(personGroup);
        return ResponseEntity.status(201).body(savedPersonGroup);
    }

    // Eliminar una relación por ID de PersonGroup
    @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar relación por ID", description = "Elimina una relación específica entre persona y grupo por su ID")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<PersonGroup> deleted = personGroupService.deleteById(id);
        if (deleted.isPresent()) {
            return ResponseEntity.ok(deleted.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un PersonGroup entregando el objeto PersonGroup
    @DeleteMapping
        @Operation(summary = "Eliminar relación proporcionando el objeto completo", description = "Elimina una relación entre persona y grupo proporcionando el objeto PersonGroup completo")
    public ResponseEntity<?> delete(@RequestBody PersonGroup personGroup) {
        Optional<PersonGroup> deleted = personGroupService.delete(personGroup);
        if (deleted.isPresent()) {
            return ResponseEntity.ok(deleted.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary =  "Eliminar un PersonGroup por ID de persona e ID de grupo de escape")
    @DeleteMapping("/person/{personId}/escapegroup/{escapeGroupId}")
    public ResponseEntity<?> deleteByPersonIdAndEscapeGroupId(@PathVariable Long personId, @PathVariable Long escapeGroupId) {
        Optional<PersonGroup> deleted = personGroupService.deleteByPersonIdAndEscapeGroupId(personId, escapeGroupId);
        if (deleted.isPresent()) {
            return ResponseEntity.ok(deleted.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
