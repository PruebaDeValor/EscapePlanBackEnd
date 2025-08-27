package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;

public interface RoomRepository extends CrudRepository<Room, Long> {

    Optional<Room> findByName(String name);

    List<Room> findByLocation(Location location);

    List<Room> findByLocationId(Long locationId);

    List<Room> findByLocationName(String locationName);
    
    List<Room> findByTheme(String theme);

    List<Room> findByMinimumCapacity(Long minimumCapacity);

    List<Room> findByMaximumCapacity(Long maximumCapacity);
    
}


