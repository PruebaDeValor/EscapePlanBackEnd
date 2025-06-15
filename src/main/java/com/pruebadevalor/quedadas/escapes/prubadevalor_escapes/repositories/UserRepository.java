package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    // Additional query methods can be defined here if needed

}
