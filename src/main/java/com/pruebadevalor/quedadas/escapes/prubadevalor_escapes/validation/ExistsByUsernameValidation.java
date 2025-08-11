package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistsByUsernameValidation implements ConstraintValidator<ExistsByUsername, String> {
    
    @Autowired
    private UserService service;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (service == null){
            return true; // If service is not available, skip validation
        }
            
       return !service.existsByUsername(username);
    }

}
