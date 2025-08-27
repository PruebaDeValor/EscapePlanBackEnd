package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;

public interface LocationService {

    List<Location> findAll();

    Optional<Location> findById(Long id);

    Location save(Location location);

    Optional<Location> deleteById(Long id);

    Optional<Location> delete(Location location);

    Optional<Location> findByName(String name);

}
