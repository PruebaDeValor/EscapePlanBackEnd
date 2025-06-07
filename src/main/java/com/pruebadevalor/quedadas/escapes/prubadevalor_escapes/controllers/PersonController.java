package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.PersonService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controlador REST para la entidad Person.
 * Proporciona endpoints para gestionar personas.
 **/
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    // Buscar todas las personas
    @GetMapping
    public List<Person> list() {
        return personService.findAll();
    }

    // Buscar una persona por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if(personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Endpoint para buscar una persona por email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Optional<Person> personOptional = personService.findByEmail(email);
        if (personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // Crear una nueva persona validando el email
    @PostMapping
public ResponseEntity<?> create(@Valid @RequestBody Person person) {
    // Comprobar si ya existe una persona con ese email
    Optional<Person> existing = personService.findByEmail(person.getEmail());
    if (existing.isPresent()) {
        return ResponseEntity.badRequest().body("El email ya está registrado.");
    }
    Person personNew = personService.save(person);
    return ResponseEntity.status(HttpStatus.CREATED).body(personNew);
}

    // Actualizar una persona existente
    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    // Eliminar una persona por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Person person = new Person();
        person.setId(id);
        Optional<Person> personOptional = personService.delete(person);
        if(personOptional.isPresent()) {
            return ResponseEntity.ok(personOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
