package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository personRepository;

    @GetMapping
    public List<User> list() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result) {
        if(result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));        
    }

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User userUpdated = service.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userUpdated);
    }

    // Añadir una persona a un usuario
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{userId}/person/{personId}")
public ResponseEntity<?> assignPersonToUser(@PathVariable Long userId, @PathVariable Long personId) {
    // Busca el usuario
    User user = service.findById(userId)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    // Busca la persona
    Person person = personRepository.findById(personId)
        .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

    // Asocia la persona al usuario
    user.setPerson(person);
    User updatedUser = service.save(user);

    return ResponseEntity.ok(updatedUser);
}


    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result) {
        user.setAdmin(false);
        return create(user, result);       
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }



}
