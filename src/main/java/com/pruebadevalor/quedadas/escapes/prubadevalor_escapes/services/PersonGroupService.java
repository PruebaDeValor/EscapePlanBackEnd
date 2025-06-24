package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.access.method.P;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;

public interface PersonGroupService {

    List<PersonGroup> findAll();

    Optional<PersonGroup> findById(Long id);

    Optional<PersonGroup> findByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    PersonGroup saveByPersonIdEscapeGroupIdRoleAndStatus (Long personId, Long escapeGroupId, PersonGroup.Role role, PersonGroup.Status status);

    List<PersonGroup> findByPersonId(Long personId);
    List<PersonGroup> findByEscapeGroupId(Long escapeGroupId);
    
    PersonGroup save(PersonGroup personGroup);

    void deleteById(Long id);

    Optional<PersonGroup> delete(PersonGroup personGroup);

    void deleteByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    
}
