package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;

public interface PersonService {

    List<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person person);

    void deleteById(Long id);

    Optional<Person> delete(Person person);

    Optional<Person> findByEmail(String email);


    
}
