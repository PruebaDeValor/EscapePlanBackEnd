package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import org.springframework.data.repository.CrudRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import java.util.Optional;


public interface LocationRepository extends CrudRepository<Location, Long> {
    Optional<Location> findByName(String name);
}


