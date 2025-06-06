package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeFavourite;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;

public interface EscapeFavouriteRepository extends CrudRepository<EscapeFavourite, Long> {

    List<EscapeFavourite> findByPerson(Person person);

    Optional<EscapeFavourite> findByRoomId(Long escapeId);

    

}
