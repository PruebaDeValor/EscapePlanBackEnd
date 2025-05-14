package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<Person> delete(Person person) {
        Optional<Person> personOptional = personRepository.findById(person.getId());
        personOptional.ifPresent(personDb -> {
            personRepository.delete(personDb);
        });
        return personOptional;
        
    }

}
