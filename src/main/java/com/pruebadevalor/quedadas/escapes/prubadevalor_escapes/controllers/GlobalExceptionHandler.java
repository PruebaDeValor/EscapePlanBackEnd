package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.PersonGroupServiceImpl;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.SessionServiceImpl;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.RoomServiceImpl;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.LocationServiceImpl;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersonGroupServiceImpl.PersonGroupBusinessException.class)
    public ResponseEntity<String> handlePersonGroupBusinessException(PersonGroupServiceImpl.PersonGroupBusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Captura cualquier SessionBusinessException lanzada en la app
    @ExceptionHandler(SessionServiceImpl.SessionBusinessException.class)
    public ResponseEntity<String> handleSessionBusinessException(SessionServiceImpl.SessionBusinessException ex) {
        // Devuelve un error 400 (Bad Request) y el mensaje de la excepción
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(RoomServiceImpl.RoomBusinessException.class)
    public ResponseEntity<String> handleRoomBusinessException(RoomServiceImpl.RoomBusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(LocationServiceImpl.LocationBusinessException.class)
    public ResponseEntity<String> handleLocationBusinessException(LocationServiceImpl.
    LocationBusinessException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Puedes agregar otros manejadores aquí si lo necesitas
}
