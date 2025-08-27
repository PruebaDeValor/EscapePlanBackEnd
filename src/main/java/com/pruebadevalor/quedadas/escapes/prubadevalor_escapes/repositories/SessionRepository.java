package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session.Status;

import java.util.List;


public interface SessionRepository extends CrudRepository<Session, Long> {
   public List<Session> findByEscapeGroupIdAndStatus(Long escapeGroupId, Status status);
   public List<Session> findByEscapeGroupId(Long escapeGroupId);
}


