package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;

public interface PersonGroupRepository extends CrudRepository<PersonGroup, Long> {
    /**
     * Busca un PersonGroup por el ID de la persona y el ID del grupo de escape.
     *
     * @param personId ID de la persona.
     * @param escapeGroupId ID del grupo de escape.
     * @return Un Optional que contiene el PersonGroup si se encuentra, o vacío si no.
     */

    Optional<PersonGroup> findByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    /**
     * Elimina un PersonGroup por el ID de la persona y el ID del grupo de escape.
     *
     * @param personId ID de la persona.
     * @param escapeGroupId ID del grupo de escape.
     */
    void deleteByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);


    /**
     * Verifica si existe un PersonGroup por el ID de la persona y el ID del grupo de escape.
     *
     * @param personId ID de la persona.
     * @param escapeGroupId ID del grupo de escape.
     * @return true si existe, false en caso contrario.
     */
    boolean existsByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId);

    /**
     * Busca todos los PersonGroup por el ID de la persona.
     *
     * @param personId ID de la persona.
     * @return Una lista de PersonGroup asociados a la persona.
     */
    List<PersonGroup> findAllByPersonId(Long personId);

    List<PersonGroup> findByEscapeGroupId(Long escapeGroupId);

    List<PersonGroup> findAllByEscapeGroup(EscapeGroup escapeGroup);

    


}

