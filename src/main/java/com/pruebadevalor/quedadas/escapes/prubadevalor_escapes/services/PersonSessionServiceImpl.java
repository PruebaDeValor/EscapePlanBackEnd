package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonSession;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonSessionRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.SessionRepository;

public class PersonSessionServiceImpl implements PersonSessionService {
    // Excepción para lógica de negocio de PersonSession
    
    @Autowired
    private PersonSessionRepository personSessionRepository;
    
    @Autowired
    private SessionRepository sessionRepository;
    
    @Autowired
    private PersonRepository personRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<PersonSession> getAllPersonSessions() {
        List<PersonSession> personSessions = (List<PersonSession>) personSessionRepository.findAll();
        if(personSessions.isEmpty()) {
            throw new PersonSessionBusinessException("No person sessions found.");
        }
        return personSessions;
    }
    
    @Override
    public Optional<PersonSession> getPersonSessionById(Long id) {
        Optional<PersonSession> optionalPersonSession = personSessionRepository.findById(id);
        if (optionalPersonSession.isEmpty()) {
            throw new PersonSessionBusinessException("Person session not found.");
        }
        return optionalPersonSession;
    }
    
    @Override
    public List<PersonSession> getPersonSessionsByPersonId(Long personId) {
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isEmpty()) {
            throw new PersonSessionBusinessException("Person not found.");
        }
        List<PersonSession> personSessions = personSessionRepository.findByPerson(optionalPerson.get());
        if(personSessions.isEmpty()) {
            throw new PersonSessionBusinessException("No person sessions found for this person.");
        }
        return personSessions;
        
    }
    @Override
    public List<PersonSession> getPersonSessionsBySessionId(Long sessionId) {
        Optional<Session> optionalSession = sessionRepository.findById(sessionId);
        if(optionalSession.isEmpty()) {
            throw new PersonSessionBusinessException("Session not found.");
        }
        List<PersonSession> personSessions = personSessionRepository.findBySession(optionalSession.get());
        if(personSessions.isEmpty()) {
            throw new PersonSessionBusinessException("No person sessions found for this session.");
        }
        return personSessions;
    }
    
    @Override
    public PersonSession createPersonSession(PersonSession personSession) {
        Session session = personSession.getSession();
        Person person = personSession.getPerson();
        if(personSession == null|| person == null ||
        session == null) {
            throw new PersonSessionBusinessException("Person session, person or session cannot be null.");
        }
        Optional<PersonSession> existingPersonSession = 
        personSessionRepository.findByPersonAndSession(person, session);
        if(existingPersonSession.isPresent()) {
            throw new PersonSessionBusinessException("Person is already registered for this session.");
        }
        if(session.isFullCapacity()) {
            throw new PersonSessionBusinessException("Session is already full.");
        }
        //guardamos el personSession y creamos una variable con ese personSession
        // para añadirlo a la lista de personSessions de la sesión
        PersonSession newPersonSession = personSessionRepository.save(personSession);
        List<PersonSession> newPersonSessions = session.getPersonSessions();
        newPersonSessions.add(newPersonSession);
        session.setPersonSessions(newPersonSessions);
        //comprobamos si ahora la sesión está llena
        int newPersonSessionsSize = newPersonSessions.size();
        if(newPersonSessionsSize == session.getRequestedCapacity()) {
            session.setFullCapacity(true);
        }
        //guardamos la sesión actualizada
        sessionRepository.save(session);
        
        return newPersonSession;
    }
    
    @Override
    public PersonSession createPersonSessionBySessionAndPersonIds(Long sessionId, Long personId) {
        Optional<Session> optionalSession = sessionRepository.findById(sessionId);
        if(optionalSession.isEmpty()) {
            throw new PersonSessionBusinessException("Session not found.");
        }
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if(optionalPerson.isEmpty()) {
            throw new PersonSessionBusinessException("Person not found.");
        }
        PersonSession personSession = new PersonSession();
        personSession.setPerson(optionalPerson.get());
        personSession.setSession(optionalSession.get());
        return createPersonSession(personSession);
    }
    
    @Override
    public PersonSession updatePersonSession(Long id, PersonSession personSession) {
        if(id==null || personSession==null) {
            throw new PersonSessionBusinessException("ID or person session cannot be null.");
        }
        Optional<PersonSession> existingPersonSession = personSessionRepository.findById(id);
        if(existingPersonSession.isEmpty()) {
            throw new PersonSessionBusinessException("Person session not found.");
        }
        personSession.setId(id);
        return personSessionRepository.save(personSession);
    }
    
    @Override
    public Optional<PersonSession> deletePersonSession(Long id) {
        if(id==null) {
            throw new PersonSessionBusinessException("ID cannot be null.");
        }
        Optional<PersonSession> existingPersonSession = personSessionRepository.findById(id);
        if(existingPersonSession.isEmpty()) {
            throw new PersonSessionBusinessException("Person session not found.");
        }
        personSessionRepository.delete(existingPersonSession.get());
        //actualizamos la sesión para eliminar el personSession de su lista
        Session session = existingPersonSession.get().getSession();
        List<PersonSession> newPersonSessions = session.getPersonSessions();
        newPersonSessions.remove(existingPersonSession.get());
        session.setPersonSessions(newPersonSessions);
        //comprobamos si la sesión ya no está llena
        int newPersonSessionsSize = newPersonSessions.size();
        if(newPersonSessionsSize == session.getRequestedCapacity()) {
            session.setFullCapacity(true);
        }else {
            session.setFullCapacity(false);
        }
        sessionRepository.save(session);
        return existingPersonSession;
    }
    
    public static class PersonSessionBusinessException extends RuntimeException {
        public PersonSessionBusinessException(String message) {
            super(message);
        }
    }
    
    
}
