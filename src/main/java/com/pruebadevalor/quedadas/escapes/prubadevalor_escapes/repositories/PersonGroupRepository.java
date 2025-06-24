package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;

public interface PersonGroupRepository extends CrudRepository<PersonGroup, Long> {

    boolean existsByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    Optional<PersonGroup> findByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);
}

