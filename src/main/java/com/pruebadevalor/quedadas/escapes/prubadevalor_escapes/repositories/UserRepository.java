package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

   boolean existsByUsername(String username);
   
   Optional<User> findByUsername(String username);
}
