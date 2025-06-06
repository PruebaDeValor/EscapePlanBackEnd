package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

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
    public List<EscapeFavourite> list() {
        return escapeFavouriteService.findAll();
    }

    // Para buscar un favorito por ID.
    // Endpoint: GET /api/escapes/favourites/{id}

    @GetMapping("/{id}")
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
    public ResponseEntity<EscapeFavourite> create(@RequestBody EscapeFavourite escapeFavourite) {
        EscapeFavourite escapeFavouriteNew = escapeFavouriteService.save(escapeFavourite);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeFavouriteNew);
    }

    // Eliminar un favorito por ID.
    // Endpoint: DELETE /api/escapes/favourites/{id}
    @DeleteMapping("/{id}")
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
    public ResponseEntity<?> findByRoomId(@PathVariable Long escapeId) {
        Optional<EscapeFavourite> escapeFavouriteOptional = escapeFavouriteService.findByRoomId(escapeId);
        if (escapeFavouriteOptional.isPresent()) {
            return ResponseEntity.ok(escapeFavouriteOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar favoritos por ID de usuario.
    // Endpoint: GET /api/escapes/favourites/person/{userId}
    @GetMapping("/person/id={userId}")
    public ResponseEntity<?> findByPerson(@PathVariable Long userId) {
        List<EscapeFavourite> escapeFavourites = escapeFavouriteService.findByPerson(userId);
        if (!escapeFavourites.isEmpty()) {
            return ResponseEntity.ok(escapeFavourites);
        }
        return ResponseEntity.notFound().build();
    }
}
