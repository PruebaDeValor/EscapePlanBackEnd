package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByEmail(String email);
    
}