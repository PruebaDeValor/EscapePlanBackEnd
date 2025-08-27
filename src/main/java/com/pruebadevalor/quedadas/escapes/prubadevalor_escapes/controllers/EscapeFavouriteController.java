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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeFavourite;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.EscapeFavouriteService;

@RestController
@RequestMapping("/api/escapes/favourites")
// Controlador REST para la entidad EscapeFavourite.
// Proporciona endpoints para gestionar los escapes señalados como favoritos.
public class EscapeFavouriteController {

    @Autowired
    private EscapeFavouriteService escapeFavouriteService;

    // Aquí se pueden definir los endpoints para gestionar los favoritos de los escapes.

    // Para listar todas las relaciones de favoritos de cada usuario.
    // Endpoint: GET /api/escapes/favourites
    @GetMapping
        @Operation(summary = "Listar todos los favoritos", description = "Devuelve todas las relaciones de favoritos de escape rooms")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Lista de favoritos",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "[{\"id\": 1, \"room\": {\"id\": 2}, \"person\": {\"id\": 3}}]")
                )
            )
        })
    public List<EscapeFavourite> list() {
        return escapeFavouriteService.findAll();
    }

    // Para buscar un favorito por ID.
    // Endpoint: GET /api/escapes/favourites/{id}

    @GetMapping("/{id}")
        @Operation(summary = "Obtener favorito por ID", description = "Devuelve un favorito específico por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Favorito encontrado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"room\": {\"id\": 2}, \"person\": {\"id\": 3}}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Favorito no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"EscapeFavourite with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<EscapeFavourite> escapeFavouriteOptional = escapeFavouriteService.findById(id);
        if (escapeFavouriteOptional.isPresent()) {
            return ResponseEntity.ok(escapeFavouriteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo favorito.
    // Endpoint: POST /api/escapes/favourites
    @PostMapping
        @Operation(summary = "Crear nuevo favorito", description = "Crea una nueva relación de favorito para una escape room")
        @ApiResponses({
            @ApiResponse(
                responseCode = "201",
                description = "Favorito creado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "{\"room\": {\"id\": 2}, \"person\": {\"id\": 3}}")
                )
            )
        })
    public ResponseEntity<EscapeFavourite> create(@RequestBody EscapeFavourite escapeFavourite) {
        EscapeFavourite escapeFavouriteNew = escapeFavouriteService.save(escapeFavourite);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeFavouriteNew);
    }

    // Eliminar un favorito por ID.
    // Endpoint: DELETE /api/escapes/favourites/{id}
    @DeleteMapping("/{id}")
        @Operation(summary = "Eliminar favorito por ID", description = "Elimina un favorito específico por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Favorito eliminado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"room\": {\"id\": 2}, \"person\": {\"id\": 3}}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Favorito no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"EscapeFavourite with id 1 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> delete (@PathVariable Long id) {
        EscapeFavourite escapeFavourite = new EscapeFavourite();
        escapeFavourite.setId(id);
        Optional<EscapeFavourite> escapeFavouriteOptional = escapeFavouriteService.delete(escapeFavourite);
        if (escapeFavouriteOptional.isPresent()) {
            return ResponseEntity.ok(escapeFavouriteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar favoritos por ID de escape.
    // Endpoint: GET /api/escapes/favourites/room/{escapeId}
    @GetMapping("/room/{escapeId}")
        @Operation(summary = "Buscar favorito por ID de escape room", description = "Devuelve el favorito asociado a una escape room por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Favorito encontrado",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "{\"id\": 1, \"room\": {\"id\": 2}, \"person\": {\"id\": 3}}")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Favorito no encontrado",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"EscapeFavourite with room id 2 does not exist.\"}")
                )
            )
        })
    public ResponseEntity<?> findByRoomId(@PathVariable Long escapeId) {
        Optional<EscapeFavourite> escapeFavouriteOptional = escapeFavouriteService.findByRoomId(escapeId);
        if (escapeFavouriteOptional.isPresent()) {
            return ResponseEntity.ok(escapeFavouriteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar favoritos por ID de usuario.
    // Endpoint: GET /api/escapes/favourites/person/{userId}
    @GetMapping("/person/{userId}")
        @Operation(summary = "Buscar favoritos por ID de usuario", description = "Devuelve todos los favoritos asociados a un usuario por su ID")
        @ApiResponses({
            @ApiResponse(
                responseCode = "200",
                description = "Favoritos encontrados",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = EscapeFavourite.class),
                    examples = @ExampleObject(value = "[{\"id\": 1, \"room\": {\"id\": 2}, \"person\": {\"id\": 3}}]")
                )
            ),
            @ApiResponse(
                responseCode = "404",
                description = "Favoritos no encontrados",
                content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(value = "{\"error\": \"No favourites found for user id 3.\"}")
                )
            )
        })
    public ResponseEntity<?> findByPerson(@PathVariable Long userId) {
        List<EscapeFavourite> escapeFavourites = escapeFavouriteService.findByPerson(userId);
        if (!escapeFavourites.isEmpty()) {
            return ResponseEntity.ok(escapeFavourites);
        }
        return ResponseEntity.notFound().build();
    }
}
