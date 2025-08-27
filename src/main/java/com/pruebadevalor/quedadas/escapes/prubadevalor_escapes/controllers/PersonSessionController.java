package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonSession;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.PersonSessionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/personSessions")
@Tag(name = "PersonSessions", description = "Endpoints para gestionar las relaciones entre personas y sesiones")
public class PersonSessionController {

    @Autowired
    private PersonSessionService personSessionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<PersonSession> getAllPersonSessions() {
        return personSessionService.getAllPersonSessions();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<PersonSession> getPersonSessionById(@PathVariable Long id){
        Optional<PersonSession> optionalPersonSession = personSessionService.getPersonSessionById(id);
        if(optionalPersonSession.isPresent()){
            return ResponseEntity.ok(optionalPersonSession.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/person/id/{personId}")
    public ResponseEntity<List<PersonSession>> getPersonSessionsBySessionId(@PathVariable Long sessionId){
        List<PersonSession> personSessions = personSessionService.getPersonSessionsBySessionId(sessionId);
        if(!personSessions.isEmpty()){
            return ResponseEntity.ok(personSessions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public ResponseEntity<?> createPersonSession(@RequestBody PersonSession personSession) {
        PersonSession createdPersonSession = personSessionService.createPersonSession(personSession);
        if(createdPersonSession == null){
            return ResponseEntity.badRequest().body("Error creating PersonSession.");
        } else {
            return ResponseEntity.ok(createdPersonSession);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/session/{sessionId}/person/{personId}")
    public ResponseEntity<?> createPersonSessionBySessionAndPersonIds (@PathVariable Long sessionId,
        @PathVariable Long personId){
        PersonSession createdPersonSession = personSessionService.createPersonSessionBySessionAndPersonIds(sessionId, personId);
        if(createdPersonSession == null){
            return ResponseEntity.badRequest().body("Error creating PersonSession.");
        } else {
            return ResponseEntity.ok(createdPersonSession);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersonSession(@PathVariable Long id, @RequestBody PersonSession personSession) {
        PersonSession updatedPersonSession = personSessionService.updatePersonSession(id, personSession);
        if(updatedPersonSession == null){
            return ResponseEntity.badRequest().body("Error updating PersonSession.");
        } else {
            return ResponseEntity.ok(updatedPersonSession);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersonSession(@PathVariable Long id) {
        Optional<PersonSession> deletedPersonSession = personSessionService.deletePersonSession(id);
        if(deletedPersonSession.isPresent()){
            return ResponseEntity.ok(deletedPersonSession.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
          

}
