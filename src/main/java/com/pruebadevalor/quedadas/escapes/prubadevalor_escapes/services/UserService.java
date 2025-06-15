package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);

    
}
