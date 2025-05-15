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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.EscapeGroupService;

@RestController
@RequestMapping("/api/escapegroup")
// Controlador REST para la entidad EscapeGroup.
// Proporciona endpoints para gestionar grupos de escape.
public class EscapeGroupController {

    @Autowired
    private EscapeGroupService escapeGroupService;

    // Buscar todos los grupos de escape
    // Endpoint: GET /api/escapegroup
    @GetMapping
    public List<EscapeGroup> list() {
        return escapeGroupService.findAll();
    }

    // Buscar un grupo de escape por ID
    // Endpoint: GET /api/escapegroup/{id}

    @GetMapping("/{id}")
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
    public ResponseEntity<EscapeGroup> create(@RequestBody EscapeGroup escapeGroup) {
        EscapeGroup escapeGroupNew = escapeGroupService.save(escapeGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeGroupNew);
    }

    // Actualizar un grupo de escape existente
    // Endpoint: PUT /api/escapegroup/{id}
    @PutMapping("/{id}")
    public ResponseEntity<EscapeGroup> update(@PathVariable Long id, @RequestBody EscapeGroup escapeGroup) {
        escapeGroup.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(escapeGroupService.save(escapeGroup));
    }

    // Eliminar un grupo de escape por ID
    // Endpoint: DELETE /api/escapegroup/{id}
    @DeleteMapping("/{id}")
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
