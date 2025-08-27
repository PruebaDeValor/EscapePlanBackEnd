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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.EscapeGroupService;

@RestController
@RequestMapping("/api/escapegroups")
// Controlador REST para la entidad EscapeGroup.
// Proporciona endpoints para gestionar grupos de escape.
public class EscapeGroupController {

    @Autowired
    private EscapeGroupService escapeGroupService;

    // Buscar todos los grupos de escape
    // Endpoint: GET /api/escapegroup
    @GetMapping
        @Operation(summary = "Listar todos los grupos de escape", description = "Devuelve todos los grupos de escape registrados")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Lista de grupos de escape",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeGroup.class),
                    examples = @ExampleObject(value = "[{\"id\": 1, \"name\": \"Grupo Fantasma\"}]")
                )
            )
        })
    public List<EscapeGroup> list() {
        return escapeGroupService.findAll();
    }

    // Buscar un grupo de escape por ID
    // Endpoint: GET /api/escapegroup/{id}

    @GetMapping("/{id}")
        @Operation(summary = "Obtener grupo de escape por ID", description = "Devuelve un grupo de escape específico por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Grupo de escape encontrado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeGroup.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Grupo Fantasma\"}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Grupo de escape no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"EscapeGroup with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EscapeGroup> escapeGroupOptional = escapeGroupService.findById(id);
        if(escapeGroupOptional.isPresent()) {
            return ResponseEntity.ok(escapeGroupOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo grupo de escape
    // Endpoint: POST /api/escapegroup
    @PostMapping
        @Operation(summary = "Crear nuevo grupo de escape", description = "Crea un nuevo grupo de escape")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Grupo de escape creado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeGroup.class),
                    examples = @ExampleObject(value = "{\"name\": \"Grupo Fantasma\"}")
                )
            )
        })
    public ResponseEntity<EscapeGroup> create(@RequestBody EscapeGroup escapeGroup) {
        EscapeGroup escapeGroupNew = escapeGroupService.save(escapeGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeGroupNew);
    }

    // Actualizar un grupo de escape existente
    // Endpoint: PUT /api/escapegroup/{id}
    @PutMapping("/{id}")
        @Operation(summary = "Actualizar grupo de escape", description = "Actualiza los datos de un grupo de escape existente")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Grupo de escape actualizado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeGroup.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Grupo Fantasma\"}")
                )
            )
        })
    public ResponseEntity<EscapeGroup> update(@PathVariable Long id, @RequestBody EscapeGroup escapeGroup) {
        escapeGroup.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeGroupService.save(escapeGroup));
    }

    // Eliminar un grupo de escape por ID
    // Endpoint: DELETE /api/escapegroup/{id}
    @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar grupo de escape por ID", description = "Elimina un grupo de escape específico por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Grupo de escape eliminado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeGroup.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Grupo Fantasma\"}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Grupo de escape no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"EscapeGroup with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> delete(@PathVariable Long id) {
        EscapeGroup escapeGroup = new EscapeGroup();
        escapeGroup.setId(id);
        Optional<EscapeGroup> escapeGroupOptional = escapeGroupService.delete(escapeGroup);
        if(escapeGroupOptional.isPresent()) {
            return ResponseEntity.ok(escapeGroupOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
