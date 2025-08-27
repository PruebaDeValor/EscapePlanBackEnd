package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonSession;

public interface PersonSessionService {

    List<PersonSession> getAllPersonSessions();

    Optional<PersonSession> getPersonSessionById(Long id);

    List<PersonSession> getPersonSessionsByPersonId(Long personId);

    List<PersonSession> getPersonSessionsBySessionId(Long sessionId);

    PersonSession createPersonSession(PersonSession personSession);

    PersonSession createPersonSessionBySessionAndPersonIds(Long sessionId, Long personId);

    PersonSession updatePersonSession(Long id, PersonSession personSession);

    Optional<PersonSession> deletePersonSession(Long id);

}
