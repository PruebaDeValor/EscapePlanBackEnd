package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;

public interface PersonGroupService {

    List<PersonGroup> findAll();

    Optional<PersonGroup> findById(Long id);

    Optional<PersonGroup> findByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    PersonGroup saveByPersonIdEscapeGroupIdRoleAndStatus (Long personId, Long escapeGroupId, PersonGroup.Role role, PersonGroup.Status status);

    List<PersonGroup> findByEscapeGroupId(Long escapeGroupId);
    
    PersonGroup save(PersonGroup personGroup);

    Optional<PersonGroup> deleteById(Long id);

    Optional<PersonGroup> delete(PersonGroup personGroup);

    Optional<PersonGroup> deleteByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    List<PersonGroup> findAllByPersonId(Long personId);

    
}
