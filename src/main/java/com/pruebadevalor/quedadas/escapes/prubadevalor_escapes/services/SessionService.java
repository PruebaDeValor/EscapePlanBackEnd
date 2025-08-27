package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.SessionSimpleDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Session.Status;

public interface SessionService {

    List<Session> findAll();

    Optional<Session> findById(Long id);

    Session save(Session session);

    Optional<Session> deleteById(Long id);

    Optional<Session> delete(Session session);

    public List<Session> findByEscapeGroupIdAndStatus(Long escapeGroupId, Status status);

    public List<Session> findByEscapeGroupId(Long escapeGroupId);

    public Session createByRoomIdAndGroupId(Long roomId, Long groupId, Long organizedByPersonId, SessionSimpleDto sessionDto);

    public Session update(Long id, Session session);
}
