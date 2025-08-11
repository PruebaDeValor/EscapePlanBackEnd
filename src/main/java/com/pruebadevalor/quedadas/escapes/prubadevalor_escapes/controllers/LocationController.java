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
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.LocationService;

@RestController
@RequestMapping("/api/locations")
// Controlador REST para la entidad Location.
public class LocationController {

    @Autowired
    private LocationService locationService;

    // Buscar todas las ubicaciones
    @GetMapping
    public List<Location> list() {
        return locationService.findAll();
    }

    // Buscar una ubicación por ID
    @GetMapping("/{id}")
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
    public ResponseEntity<Location> create(@RequestBody Location location) {
        Location locationNew = locationService.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationNew);
    }

    // Actualizar una ubicación existente
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Location> update(@PathVariable Long id, @RequestBody Location location) {
        location.setId(id);
        Location locationUpdated = locationService.save(location);
        return ResponseEntity.status(HttpStatus.CREATED).body(locationUpdated);
    }

    // Eliminar una ubicación por ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Location location = new Location();
        location.setId(id);
        Optional<Location> locationOptional = locationService.delete(location);
        if(locationOptional.isPresent()) {
            return ResponseEntity.ok(locationOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
