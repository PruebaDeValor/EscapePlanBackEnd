package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Locations", description = "Endpoints para gestionar ubicaciones de escape rooms")
// Controlador REST para la entidad Location.
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Buscar todas las ubicaciones
    @GetMapping
    @Operation(summary = "Listar todas las ubicaciones", description = "Devuelve todas las ubicaciones registradas")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de ubicaciones",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "[{\"id\": 1, \"name\": \"Local Fantasma\"}, {\"id\": 2, \"name\": \"Local Pirata\"}]")
            )
        )
    })
    public List<Location> list() {
        return locationService.findAll();
    }

    // Buscar una ubicación por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener ubicación por ID", description = "Devuelve una ubicación específica por su ID")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Ubicación encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Local Fantasma\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ubicación no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Location with id 1 does not exist.\"}")
            )
        )
    })
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Location> locationOptional = locationService.findById(id);
        if(locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva ubicación
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "Crear nueva ubicación", description = "Crea una nueva ubicación")
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Ubicación creada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "{\"name\": \"Local Fantasma\", \"address\": \"Calle 123\", \"city\": \"Madrid\"}")
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos inválidos",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Location name cannot be null or empty.\"}")
            )
        )
    })
    public ResponseEntity<Location> create(@RequestBody Location location) {
        Location locationNew = locationService.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationNew);
    }

    // Actualizar una ubicación existente
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar ubicación", description = "Actualiza los datos de una ubicación existente")
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Ubicación actualizada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Local Fantasma\", \"address\": \"Calle 123\", \"city\": \"Madrid\"}")
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos inválidos",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Location name cannot be null or empty.\"}")
            )
        )
    })
    public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        Location locationUpdated = locationService.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationUpdated);
    }

    // Eliminar una ubicación por ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar ubicación por ID", description = "Elimina una ubicación específica por su ID")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Ubicación eliminada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Local Fantasma\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ubicación no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Location with id 1 does not exist.\"}")
            )
        )
    })
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Location location = new Location();
        location.setId(id);
        Optional<Location> locationOptional = locationService.delete(location);
        if(locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/name/{name}")
    @Operation(summary = "Buscar ubicación por nombre", description = "Devuelve una ubicación específica por su nombre")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Ubicación encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Location.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Local Fantasma\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Ubicación no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Location with name Local Fantasma does not exist.\"}")
            )
        )
    })
    public ResponseEntity<?> search(@RequestParam String name) {
        Optional<Location> locationOptional = locationService.findByName(name);
        if(locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
