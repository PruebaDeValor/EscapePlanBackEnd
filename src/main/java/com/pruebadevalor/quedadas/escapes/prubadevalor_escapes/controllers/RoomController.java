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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.RoomsWithRatingAndCompletedCountDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.RoomService;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.SessionServiceImpl.SessionBusinessException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.ExampleObject;

@RestController
@RequestMapping("api/rooms")
@Tag(name = "Rooms", description = "Endpoints para gestionar las escape rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    @Operation(summary = "Listar todas las escape rooms", description = "Devuelve todas las escape rooms registradas")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de escape rooms",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "[{\"id\": 1, \"name\": \"Escape Fantasma\", \"isScary\": \"YES\"}, {\"id\": 2, \"name\": \"Escape Pirata\", \"isScary\": \"NO\"}]")
            )
        )
    })
    public List<Room> findAll() {
        return roomService.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    @Operation(summary = "Obtener escape room por ID", description = "Devuelve una escape room específica por su ID")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Escape room encontrada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Escape Fantasma\", \"isScary\": \"YES\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Escape room no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Room with id 1 does not exist.\"}")
            )
        )
    })
    public ResponseEntity<Room> findById(@PathVariable Long id) {
        Optional<Room> optionalRoom = roomService.findById(id);
        if (optionalRoom.isPresent()) {
            return ResponseEntity.ok(optionalRoom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/name/{name}")
        @Operation(summary = "Buscar escape room por nombre", description = "Devuelve una escape room específica por su nombre")
    public ResponseEntity<Room> findByName(@PathVariable String name) {
        Optional<Room> optionalRoom = roomService.findByName(name);
        if (optionalRoom.isPresent()) {
            return ResponseEntity.ok(optionalRoom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/location/{locationId}")
        @Operation(summary = "Buscar escape rooms por ID de local", description = "Devuelve todas las escape rooms asociadas a un local por su ID")
    public ResponseEntity<?> findByLocationId(@PathVariable Long locationId) {
        List<Room> rooms = roomService.findByLocationId(locationId);
        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rooms);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/location/name/{locationName}")
        @Operation(summary = "Buscar escape rooms por nombre de local", description = "Devuelve todas las escape rooms asociadas a un local por su nombre")
    public ResponseEntity<?> findByLocationName(@PathVariable String locationName) {
        List<Room> rooms = roomService.findByLocationName(locationName);
         if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rooms);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/theme/{theme}")
        @Operation(summary = "Buscar escape rooms por temática", description = "Devuelve todas las escape rooms que coinciden con la temática proporcionada")
    public ResponseEntity<?> findByTheme(@PathVariable String theme) {
        List<Room> rooms = roomService.findByTheme(theme);
        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rooms);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/capacity/min/{minimumCapacity}")
        @Operation(summary = "Buscar escape rooms por capacidad mínima", description = "Devuelve todas las escape rooms con una capacidad mínima igual o superior a la indicada")
    public ResponseEntity<?> findByMinCapacity(@PathVariable Long minimumCapacity) {
        List<Room> rooms = roomService.findByMinCapacity(minimumCapacity);
        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rooms);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/capacity/max/{maximumCapacity}")
        @Operation(summary = "Buscar escape rooms por capacidad máxima", description = "Devuelve todas las escape rooms con una capacidad máxima igual o inferior a la indicada")
    public ResponseEntity<?> findByMaxCapacity(@PathVariable Long maximumCapacity) {
        List<Room> rooms = roomService.findByMaxCapacity(maximumCapacity);
        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rooms);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "Crear nueva escape room", description = "Crea una nueva escape room")
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Escape room creada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "{\"name\": \"Escape Fantasma\", \"shortDescription\": \"Sala de miedo\", \"longDescription\": \"Una sala con ambientación de terror...\", \"theme\": \"Terror\", \"imageName\": \"fantasma.jpg\", \"location\": {\"id\": 1}, \"websiteUrl\": \"https://escapefantasma.com\", \"minimumCapacity\": 2, \"maximumCapacity\": 6, \"isScary\": \"YES\"}")
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos inválidos",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Room, name, and location must not be null.\"}")
            )
        )
    })
    public ResponseEntity<?> create(@RequestBody Room room) {
        Room createdRoom = roomService.save(room);
        if (createdRoom == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/location/{locationId}")
    @Operation(summary = "Crear escape room asociada a un local", description = "Crea una nueva escape room y la asocia al local indicado por su ID")
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Escape room creada y asociada al local",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "{\"name\": \"Escape Fantasma\", \"shortDescription\": \"Sala de miedo\", \"longDescription\": \"Una sala con ambientación de terror...\", \"theme\": \"Terror\", \"imageName\": \"fantasma.jpg\", \"location\": {\"id\": 1}, \"websiteUrl\": \"https://escapefantasma.com\", \"minimumCapacity\": 2, \"maximumCapacity\": 6, \"isScary\": \"YES\"}")
            )
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos inválidos",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Room, name, locationId must not be null.\"}")
            )
        )
    })
    public ResponseEntity<?> createByLocationId(@PathVariable Long locationId, @RequestBody Room room) {
        if(locationId == null) {
            return ResponseEntity.badRequest().build();
        }
        if (room == null) {
            return ResponseEntity.badRequest().build();
        }
        Room createdRoom = roomService.saveByLocationId(locationId, room);
         if (createdRoom == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping
    @Operation(summary = "Eliminar escape room por objeto", description = "Elimina una escape room proporcionando el objeto completo")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Escape room eliminada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Escape Fantasma\", \"isScary\": \"YES\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Escape room no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Room with id 1 does not exist.\"}")
            )
        )
    })
    public ResponseEntity<?> delete(@RequestBody Room room) {
        Optional<Room> deletedRoom = roomService.delete(room);
        if (deletedRoom.isPresent()) {
            return ResponseEntity.ok(deletedRoom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar escape room por ID", description = "Elimina una escape room específica por su ID")
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Escape room eliminada",
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = Room.class),
                examples = @ExampleObject(value = "{\"id\": 1, \"name\": \"Escape Fantasma\", \"isScary\": \"YES\"}")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Escape room no encontrada",
            content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(value = "{\"error\": \"Room with id 1 does not exist.\"}")
            )
        )
    })
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Room> deletedRoom = roomService.deleteById(id);
        if (deletedRoom.isPresent()) {
            return ResponseEntity.ok(deletedRoom.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/averageRating/room/{roomId}")
        @Operation(summary = "Obtener promedio de valoraciones por room", description = "Devuelve el promedio de valoraciones de las sesiones completadas de una room")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Promedio de valoraciones obtenido"),
            @ApiResponse(responseCode = "404", description = "No se encontraron valoraciones")
        })
    public ResponseEntity<?> getAverageRatingByRoomId(@PathVariable Long roomId) {
        try {
            Double averageRating = roomService.getAverageRatingForRoom(roomId);
            return ResponseEntity.ok(averageRating);
        } catch (SessionBusinessException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/averageRating")
    @Operation(
        summary = "Listar rooms con valoración media y número de sesiones completadas",
        description = "Devuelve una lista de objetos que contienen los datos básicos de cada room junto con su valoración media (averageRating) y el número total de sesiones completadas (completedCount)."
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "200",
            description = "Lista de rooms con su valoración media y total de sesiones completadas",
            content = @Content(
                mediaType = "application/json",
                array = @ArraySchema(schema = @Schema(implementation = RoomsWithRatingAndCompletedCountDto.class)),
                examples = @ExampleObject(value = "[\n  {\n    \"id\": 23,\n    \"name\": \"La Lavandería\",\n    \"shortDescription\": \"Escape room de roleplay y humor para grupos grandes.\",\n    \"longDescription\": \"La Lavandería es un escape room...\",\n    \"minimumCapacity\": 2,\n    \"maximumCapacity\": 10,\n    \"isScary\": \"NO\",\n    \"theme\": \"Humor;Roleo;Grupos;Familiar\",\n    \"imageName\": \"23.webp\",\n    \"websiteUrl\": \"https://thecityescaperoom.com/madrid/la-lavanderia-escape-room\",\n    \"locationId\": 9,\n    \"locationName\": \"Experiencity The City\",\n    \"averageRating\": 4.5,\n    \"completedCount\": 12\n  },\n  {\n    \"id\": 24,\n    \"name\": \"Ciudad de Vacaciones\",\n    \"shortDescription\": \"Escape room de humor y aventura para grupos medianos.\",\n    \"longDescription\": \"Ciudad de Vacaciones es una sala...\",\n    \"minimumCapacity\": 2,\n    \"maximumCapacity\": 7,\n    \"isScary\": \"NO\",\n    \"theme\": \"Humor;Roleo;Aventura;Familiar\",\n    \"imageName\": \"24.webp\",\n    \"websiteUrl\": \"https://thecityescaperoom.com/madrid/ciudad-de-vacaciones\",\n    \"locationId\": 9,\n    \"locationName\": \"Experiencity The City\",\n    \"averageRating\": null,\n    \"completedCount\": 0\n  }\n]")
            )
        ),
        @ApiResponse(
            responseCode = "404",
            description = "No se encontraron valoraciones o datos",
            content = @Content(mediaType = "application/json", examples = @ExampleObject(value = "{\"error\": \"No rooms with ratings and completed counts found.\"}"))
        )
    })
    public ResponseEntity<?> getRoomsWithRatingAndCompletedCount() {
        try {
            List<RoomsWithRatingAndCompletedCountDto> dtoList = roomService.getRoomsWithRatingAndCompletedCount();
            return ResponseEntity.ok(dtoList);
        } catch (SessionBusinessException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}