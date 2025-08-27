package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.SessionSimpleDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.SessionService;

import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping("/api/sessions")
@Tag(name = "Sessions", description = "Endpoints para gestionar sesiones de escape room")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
        @Operation(summary = "Obtener todas las sesiones", description = "Devuelve una lista de todas las sesiones registradas")
    public List<Session> getAllSessions() {
        return sessionService.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
        @Operation(
            summary = "Obtener sesión por ID",
            description = "Devuelve una sesión específica por su ID"
        )
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Sesión encontrada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Session.class),
                    examples = @ExampleObject(
                        value = "{\n  \"id\": 10,\n  \"room\": {\"id\": 1},\n  \"escapeGroup\": {\"id\": 2},\n  \"startTime\": \"2025-08-19T18:00:00\",\n  \"endTime\": \"2025-08-19T19:00:00\",\n  \"durationMinutes\": 60,\n  \"status\": \"COMPLETED\",\n  \"notes\": \"Sesión finalizada exitosamente\",\n  \"organizedBy\": {\"id\": 3}\n}"
                    )
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Sesión no encontrada",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                        value = "{\"error\": \"Session with id 10 does not exist.\"}"
                    )
                )
            )
        })
    public ResponseEntity<?> getSessionById(@PathVariable Long id) {
        Optional<Session> sessionOptional = sessionService.findById(id);
        if (sessionOptional.isPresent()) {
            return ResponseEntity.ok(sessionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/escapeGroup/{escapeGroupId}/status/{status}")
        @Operation(summary = "Obtener sesiones por grupo y estado", description = "Devuelve las sesiones de un grupo de escape filtradas por estado")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sesiones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron sesiones")
        })
    public ResponseEntity<?> getSessionsByEscapeGroupIdAndStatus(
            @PathVariable Long escapeGroupId, 
            @PathVariable Session.Status status) {
        List<Session> sessions = sessionService.findByEscapeGroupIdAndStatus(escapeGroupId, status);
        if (sessions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sessions);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/escapeGroup/{escapeGroupId}")
        @Operation(summary = "Obtener sesiones por grupo", description = "Devuelve todas las sesiones asociadas a un grupo de escape")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sesiones encontradas"),
            @ApiResponse(responseCode = "404", description = "No se encontraron sesiones")
        })
    public ResponseEntity<?> getSessionsByEscapeGroupId(@PathVariable Long escapeGroupId) {
        List<Session> sessions = sessionService.findByEscapeGroupId(escapeGroupId);
        if (sessions.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sessions);
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
        @Operation(summary = "Actualizar sesión", description = "Actualiza los datos de una sesión existente")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sesión actualizada"),
            @ApiResponse(responseCode = "404", description = "Sesión no encontrada")
        })
    public ResponseEntity<?> updateSession(@PathVariable Long id, @Valid @RequestBody Session session) {
        Optional<Session> optionalSession = sessionService.findById(id);
        if(optionalSession.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        session.setId(id);
        Session updatedSession = sessionService.save(session);
        return ResponseEntity.ok(updatedSession);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
        @Operation(
            summary = "Crear nueva sesión",
            description = "Crea una nueva sesión de escape room"
        )
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Sesión creada",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Session.class),
                    examples = @ExampleObject(
                        value = "{\n  \"room\": {\"id\": 1},\n  \"escapeGroup\": {\"id\": 2},\n  \"startTime\": \"2025-08-19T18:00:00\",\n  \"endTime\": \"2025-08-19T19:00:00\",\n  \"durationMinutes\": 60,\n  \"status\": \"PENDING\",\n  \"notes\": \"Primera sesión de prueba\",\n  \"organizedBy\": {\"id\": 3}\n}"
                    )
                )
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Datos inválidos",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                        value = "{\"error\": \"Session is not valid: missing required fields.\"}"
                    )
                )
            )
        })
    public ResponseEntity<?> createSession (@RequestBody Session session) {
        Session savedSession = sessionService.save(session);
        return ResponseEntity.status(201).body(savedSession);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/create/room/{roomId}/group/{groupId}/organizer/{organizerId}")
    @Operation(summary = "Crear sesión entregando room, grupo y organizador", description = "Crea una nueva sesión de escape entregando room, grupo y organizador")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Sesión creada"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<?> createSessionByRoomAndGroupAndOrganizer(@PathVariable Long roomId, @PathVariable Long groupId, @PathVariable Long organizerId, @Valid @RequestBody SessionSimpleDto sessionDto) {
        Session createdSession = sessionService.createByRoomIdAndGroupId(roomId, groupId, organizerId, sessionDto);
        if (createdSession == null) {
            return ResponseEntity.badRequest().body("Session is not valid");
        }
        return ResponseEntity.status(201).body(createdSession);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar sesión por ID", description = "Elimina una sesión específica por su ID")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sesión eliminada"),
            @ApiResponse(responseCode = "404", description = "Sesión no encontrada")
        })
    public ResponseEntity<?> deleteSessionById(@PathVariable Long id) {
        Optional<Session> sessionOptional = sessionService.deleteById(id);
        if (sessionOptional.isPresent()) {
            return ResponseEntity.ok(sessionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping
        @Operation(summary = "Eliminar sesión por objeto", description = "Elimina una sesión proporcionando el objeto completo")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Sesión eliminada"),
            @ApiResponse(responseCode = "404", description = "Sesión no encontrada")
        })
    public ResponseEntity<?> deleteSession(@RequestBody Session session) {
        Optional<Session> sessionOptional = sessionService.delete(session);
        if (sessionOptional.isPresent()) {
            return ResponseEntity.ok(sessionOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    

}
