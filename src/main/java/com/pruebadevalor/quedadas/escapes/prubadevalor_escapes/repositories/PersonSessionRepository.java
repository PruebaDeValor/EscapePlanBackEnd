package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonSession;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;

public interface PersonSessionRepository extends CrudRepository<PersonSession, Long> {
    public Optional<PersonSession> findByPersonAndSession(Person person, Session session);
    
    public List<PersonSession> findBySession(Session session);
    
    public List<PersonSession> findByPerson(Person person);
    
    // Busca todas las valoraciones de una Room en sesiones COMPLETED y rating no nulo
    @Query("SELECT ps.rating FROM PersonSession ps WHERE ps.session.room.id = :roomId AND ps.session.status = com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session.Status.COMPLETED AND ps.rating IS NOT NULL")
    List<Double> findRatingsByRoomIdForCompletedSessions(Long roomId);

    @Query("SELECT COUNT(ps) FROM PersonSession ps WHERE ps.session.room.id = :roomId AND ps.session.status = com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session.Status.COMPLETED")
    Long getTotalSessionCompletedForRoom(Long roomId);
}


