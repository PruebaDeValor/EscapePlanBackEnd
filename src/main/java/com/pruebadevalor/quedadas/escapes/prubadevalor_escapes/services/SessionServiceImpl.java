package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.PersonSessionDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.SessionSimpleDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonSession;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session.Status;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.SessionRepository;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PersonSessionService personSessionService;

    @Autowired
    private EscapeGroupService escapeGroupService;

    @Autowired
    private PersonService personService;
    
    

    @Override
    @Transactional(readOnly = true)
    public List<Session> findAll() {
        // Logic to retrieve all sessions
        return (List<Session>) sessionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Session> findById(Long id) {
        Optional<Session> optionalSession = sessionRepository.findById(id);
        if (optionalSession.isEmpty()) {
            throw new SessionBusinessException("Session with id " + id + " does not exist.");            
        }
        return optionalSession;
    }

    @Override
    @Transactional
    public Session save(Session session) {
        if (session == null ||
        session.getRoom() == null ||
        session.getEscapeGroup() == null ||
        session.getStartTime() == null) {
        throw new SessionBusinessException("Session is not valid: missing required fields.");
    }
        
        if (session.getStatus()==null) {
            session.setStatus(Session.Status.PENDING);
        }
        if (session.getNotes() != null && session.getNotes().length() > 1000) {
            throw new SessionBusinessException("Notes cannot be longer than 1000 characters.");
        
        }

        Session newSession = sessionRepository.save(session);
        Person organizedByPerson = newSession.getOrganizedBy();
        if (organizedByPerson == null||organizedByPerson.getId() == null) {
            return newSession;
        }
        PersonSession organizerPersonSession = new PersonSession();
        organizerPersonSession.setPerson(organizedByPerson);
        organizerPersonSession.setSession(newSession);
        personSessionService.createPersonSession(organizerPersonSession);
        List<PersonSession> newPersonSessions = newSession.getPersonSessions();
        if (newPersonSessions == null) {
            newPersonSessions = new ArrayList<>();
        }
        newPersonSessions.add(organizerPersonSession);
        newSession.setPersonSessions(newPersonSessions);
        if(newSession.getRequestedCapacity() != null && newSession.getRequestedCapacity() > 0) {
            if(newPersonSessions.size() == newSession.getRequestedCapacity()) {
                newSession.setFullCapacity(true);
            } else {
                newSession.setFullCapacity(false);
            }
        } else {
            newSession.setFullCapacity(false);
        }
        return sessionRepository.save(newSession);

    }

    @Override
    @Transactional
    public Session createByRoomIdAndGroupId(Long roomId, Long groupId, Long organizedByPersonId, SessionSimpleDto sessionDto) {
        
        Session session = new Session();
        //voy a extraer la lista de ids de las personas participantes y la voy a transformar en una lista de Persons
        List<PersonSessionDto> personSessionDtos = sessionDto.getPersonSessions();
        List<PersonSession> personSessions = new ArrayList<>();


        int sessionDtoPersonSessionsSize = sessionDto.getPersonSessions().size();
        Long sessionDtoRequestedCapacity = sessionDto.getRequestedCapacity();

        if (roomId == null || groupId == null || sessionDto == null) {
            throw new SessionBusinessException("Invalid input: roomId, groupId and session must not be null.");
        }

        Optional<Room> roomOptional = roomService.findById(groupId);
        if(!roomOptional.isPresent()){
            throw new SessionBusinessException("Room with id " + roomId + " does not exist.");
        }

        Optional<EscapeGroup> escapeGroupOptional = escapeGroupService.findById(groupId);
        if(!escapeGroupOptional.isPresent()){
            throw new SessionBusinessException("Escape group with id " + groupId + " does not exist.");
        }

        Optional<Person> organizedByOptional = personService.findById(organizedByPersonId);
        if(!organizedByOptional.isPresent()){
            throw new SessionBusinessException("Person with id " + organizedByPersonId + " does not exist.");
        }
        if( sessionDtoPersonSessionsSize> sessionDtoRequestedCapacity) {
            throw new SessionBusinessException("Cannot have more person sessions than requested capacity.");
        }

        if (sessionDto.getNotes() != null && sessionDto.getNotes().length() > 1000) {
            throw new SessionBusinessException("Notes cannot be longer than 1000 characters.");
        
        }

        if(sessionDtoRequestedCapacity == null || sessionDtoRequestedCapacity < 1) {
            throw new SessionBusinessException("Requested capacity must be at least 1.");
        }

        if (sessionDto.getStatus() == null) {
            session.setStatus(Session.Status.PENDING);
        } else {
            session.setStatus(Session.Status.valueOf(sessionDto.getStatus().name()));
        }

        session.setRoom(roomOptional.get());
        session.setEscapeGroup(escapeGroupOptional.get());
        session.setStartTime(sessionDto.getStartTime());
        session.setEndTime(sessionDto.getEndTime());
        session.setNotes(sessionDto.getNotes());
        session.setDurationMinutes(sessionDto.getDurationMinutes());
        session.setOrganizedBy(organizedByOptional.get());
        session.setRequestedCapacity(sessionDtoRequestedCapacity);
        if (sessionDtoPersonSessionsSize == sessionDtoRequestedCapacity) {
            session.setFullCapacity(true);
        } else {
            session.setFullCapacity(false);
            
        }
        Session savedSession = sessionRepository.save(session);
        //Aquí vamos a guardar un personSession por cada persona que estuviese en el personSessions del Dto
        if(personSessionDtos != null && !personSessionDtos.isEmpty()) {
            for (PersonSessionDto psDto : personSessionDtos) {
                Long personId = psDto.getPersonId();
                if(personId == null) {
                    throw new SessionBusinessException("Person ID in PersonSession cannot be null.");
                }
                Optional<Person> personOptional = personService.findById(personId);
                if(!personOptional.isPresent()){
                    throw new SessionBusinessException("Person with id " + personId + " does not exist.");
                }
                PersonSession personSession = new PersonSession();
                personSession.setPerson(personOptional.get());
                personSession.setSession(savedSession); // Set the session reference
                PersonSession newPersonSession = personSessionService.createPersonSession(personSession);
                //Añadimos el nuevo PersonSession a la lista
                personSessions.add(newPersonSession);
            }
        }else{return savedSession; 
            //si no hay lista de usuarios, creamos y devolvemos la sesión guardada
            }
        //Incluimos la lista de PersonSessions en la sesión guardada
        savedSession.setPersonSessions(personSessions);
        return sessionRepository.save(savedSession);            
    }
    

    @Override
    @Transactional
    public Optional<Session> deleteById(Long id) {
        if(!sessionRepository.existsById(id)) {
            throw new SessionBusinessException("Session with id " + id + " does not exist.");
        }
        Optional<Session> sessionOptional = sessionRepository.findById(id);
        if (sessionOptional.isPresent()) {
            sessionRepository.deleteById(id);
            return sessionOptional;
        }
        return Optional.empty(); // Return empty if session not found
        
    }

    @Override
    @Transactional
    public Optional<Session> delete(Session session) {
        Optional<Session> sessionOptional = sessionRepository.findById(session.getId());
        if (sessionOptional.isPresent()) {
            sessionRepository.delete(sessionOptional.get());
            return sessionOptional;
        }else {
            throw new SessionBusinessException("Session with id " + session.getId() + " does not exist.");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Session> findByEscapeGroupIdAndStatus(Long escapeGroupId, Status status) {
        if(escapeGroupId == null) {
            throw new SessionBusinessException("EscapeGroup ID cannot be null.");
        }
        if(status == null) {
            return sessionRepository.findByEscapeGroupId(escapeGroupId);
        }
        return sessionRepository.findByEscapeGroupIdAndStatus(escapeGroupId, status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Session> findByEscapeGroupId(Long escapeGroupId) {
        if(escapeGroupId == null) {
            throw new SessionBusinessException("EscapeGroup ID cannot be null.");
        }
        return sessionRepository.findByEscapeGroupId(escapeGroupId);
    }
    

    // Custom exception for Session-related business logic
    public static class SessionBusinessException extends RuntimeException {
    public SessionBusinessException(String message) {
        super(message);
    }
    }


    @Override
    @Transactional
    public Session update(Long id, Session session) {
        if (id == null || session == null) {
            throw new SessionBusinessException("Session ID and session data must not be null.");
        }

        Optional<Session> existingSessionOptional = sessionRepository.findById(id);
        if (existingSessionOptional.isEmpty()) {
            throw new SessionBusinessException("Session with id " + id + " does not exist.");
        }

        Session existingSession = existingSessionOptional.get();

        // Update fields if they are provided in the input session object
        if (session.getRoom() != null) {
            existingSession.setRoom(session.getRoom());
        }
        if (session.getEscapeGroup() != null) {
            existingSession.setEscapeGroup(session.getEscapeGroup());
        }
        if (session.getStartTime() != null) {
            existingSession.setStartTime(session.getStartTime());
        }
        if (session.getEndTime() != null) {
            existingSession.setEndTime(session.getEndTime());
        }
        if (session.getStatus() != null) {
            existingSession.setStatus(session.getStatus());
        }
        if (session.getNotes() != null) {
            if (session.getNotes().length() > 1000) {
                throw new SessionBusinessException("Notes cannot be longer than 1000 characters.");
            }
            existingSession.setNotes(session.getNotes());
        }
        if (session.getDurationMinutes() != null) {
            existingSession.setDurationMinutes(session.getDurationMinutes());
        }
        if (session.getOrganizedBy() != null) {
            existingSession.setOrganizedBy(session.getOrganizedBy());
        }

        if(session.getRequestedCapacity() != null) {
            existingSession.setRequestedCapacity(session.getRequestedCapacity());
        }

        if(session.getFullCapacity() != null) {
            existingSession.setFullCapacity(session.isFullCapacity());
        }

        return sessionRepository.save(existingSession);
    }

}



   
