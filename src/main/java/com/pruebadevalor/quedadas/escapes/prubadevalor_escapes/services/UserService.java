package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    Optional<User> findById(Long id);

    void deleteById(Long id);

    Optional<User> delete(User user);

    boolean existsByUsername(String username);
}
