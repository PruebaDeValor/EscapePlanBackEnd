package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.RoomsWithRatingAndCompletedCountDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;

public interface RoomService {

    List<Room> findAll();

    Optional<Room> findById(Long id);

    Optional<Room> findByName(String name);

    List<Room> findByLocation(Location location);

    List<Room> findByLocationId(Long locationId);

    List<Room> findByLocationName(String locationName);
    
    List<Room> findByTheme(String theme);

    List<Room> findByMinCapacity(Long minimumCapacity);

    List<Room> findByMaxCapacity(Long maximumCapacity);

    Room save(Room room);

    Room saveByLocationId(Long locationId, Room room);

    Optional<Room> delete(Room room);

    Optional<Room> deleteById(Long id);

    Double getAverageRatingForRoom(Long roomId);

    Long getTotalSessionCompletedForRoom (Long roomId);

    List<RoomsWithRatingAndCompletedCountDto> getRoomsWithRatingAndCompletedCount();









}
