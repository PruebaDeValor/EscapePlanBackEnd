package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.dto.RoomsWithRatingAndCompletedCountDto;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.LocationRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonSessionRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.RoomRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services.SessionServiceImpl.SessionBusinessException;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PersonSessionRepository personSessionRepository;

    @Override
    public List<Room> findAll() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public Optional<Room> findById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if(!optionalRoom.isPresent()) {
            throw new RoomBusinessException("Room with id " + id + " does not exist.");
        }
        return optionalRoom;
    }

    @Override
    public List<Room> findByLocation(Location location){
        if(location == null) {
            throw new RoomBusinessException("Location must not be null.");
        }
        List<Room> rooms = roomRepository.findByLocation(location);
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found for location " + location.getName());
        }
        return rooms;
    }

    @Override
    public Optional<Room> findByName(String name) {
        Optional<Room> optionalRoom = roomRepository.findByName(name);
        if(!optionalRoom.isPresent()) {
            throw new RoomBusinessException("Room with name " + name + " does not exist.");
        }
        return optionalRoom;
    }
    
    @Override
    public List<Room> findByLocationId(Long locationId) {
        if(locationId == null) {
            throw new RoomBusinessException("Location ID cannot be null.");
        }
        Optional<Location> location = locationRepository.findById(locationId);
        if (!location.isPresent()) {
            throw new RoomBusinessException("Location with ID " + locationId + " does not exist.");
        }
        List<Room> rooms = roomRepository.findByLocation(location.get());
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found for location ID " + locationId);
        }
        return rooms;
    }
    
    @Override
    public List<Room> findByLocationName(String locationName) {
        Optional<Location> location = locationRepository.findByName(locationName);
        if (!location.isPresent()) {
            throw new RoomBusinessException("Location with name " + locationName + " does not exist.");
        }
        List<Room> rooms = roomRepository.findByLocation(location.get());
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found for location name " + locationName);
        }
        return rooms;
    }

    @Override
    public List<Room> findByTheme(String theme) {
        List<Room> rooms = roomRepository.findByTheme(theme);
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found for theme " + theme);
        }
        return rooms;
    }
    
    @Override
    public List<Room> findByMinCapacity(Long minimumCapacity) {
        List<Room> rooms = roomRepository.findByMinimumCapacity(minimumCapacity);
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found with minimum capacity " + minimumCapacity);
        }
        return rooms;
    }
    
    @Override
    public List<Room> findByMaxCapacity(Long maximumCapacity) {
        List<Room> rooms = roomRepository.findByMaximumCapacity(maximumCapacity);
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found with maximum capacity " + maximumCapacity);
        }
        return rooms;
    }
    
    @Override
    public Room save(Room room) {
        if(room == null || room.getName() == null || room.getLocation() == null) {
            throw new RoomBusinessException("Room, name, and location must not be null.");
        }
        return roomRepository.save(room);
    }

    @Override
    public Room saveByLocationId(Long locationId, Room room) {
        if(locationId == null) {
            throw new RoomBusinessException("Location ID cannot be null.");
        }
        if(room == null || room.getName() == null) {
            throw new RoomBusinessException("Room and name must not be null.");
        }
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new RoomBusinessException("Location with ID " + locationId + " does not exist."));
        room.setLocation(location);
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> delete(Room room) {
        Optional<Room> roomOptional = roomRepository.findById(room.getId());
        if (roomOptional.isPresent()) {
            roomRepository.delete(roomOptional.get());
            return roomOptional;
        } else {
            throw new RoomBusinessException("Room with id " + room.getId() + " does not exist.");
        }
    }
    
    @Override
    public Optional<Room> deleteById(Long id) {
        Optional<Room> roomOptional = roomRepository.findById(id);
        if (!roomOptional.isPresent()) {
            throw new RoomBusinessException("Room with id " + id + " does not exist.");
        }
        roomRepository.delete(roomOptional.get());
        return roomOptional;
    }

    @Override
    public Double getAverageRatingForRoom(Long roomId) {
    if (roomId == null) {
        throw new SessionBusinessException("Room ID cannot be null.");
    }
        List<Double> ratings = personSessionRepository.findRatingsByRoomIdForCompletedSessions(roomId);
    if (ratings == null || ratings.isEmpty()) {
        // No ratings available for this room yet
        return null;
    }
    double sum = 0.0;
    for (Double rating : ratings) {
        if (rating != null) {
            sum += rating;
        }
    }
    return sum / ratings.size();
    }
    
    // Excepción general para lógica de negocio de Room
    public static class RoomBusinessException extends RuntimeException {
        public RoomBusinessException(String message) {
            super(message);
        }
}

    @Override
    public Long getTotalSessionCompletedForRoom(Long roomId) {
        if(roomId == null) {
            throw new RoomBusinessException("Room ID cannot be null.");
        }
        Long totalCompleted = personSessionRepository.getTotalSessionCompletedForRoom(roomId);
        if (totalCompleted == null) {
            // If repository returns null, treat as 0 completed sessions
            return 0L;
        }
        return totalCompleted;
    }

    @Override
    public List<RoomsWithRatingAndCompletedCountDto> getRoomsWithRatingAndCompletedCount() {
        List<RoomsWithRatingAndCompletedCountDto> roomsListWithRatingAndCompletedCountDtos = new ArrayList<>();
        List<Room> rooms = (List<Room>) roomRepository.findAll();
        if(rooms.isEmpty()) {
            throw new RoomBusinessException("No rooms found.");
        }
        for (Room room : rooms) {
            RoomsWithRatingAndCompletedCountDto dto = new RoomsWithRatingAndCompletedCountDto();
            Long completedCount = personSessionRepository.getTotalSessionCompletedForRoom(room.getId());
            if (completedCount == null) {
                completedCount = 0L;
            }
            Double averageRating = getAverageRatingForRoom(room.getId());
            // averageRating may be null when no ratings exist; DTO should reflect that
            dto.setCompletedCount(completedCount);
            dto.setAverageRating(averageRating);
            dto.setId(room.getId());
            dto.setName(room.getName());
            dto.setShortDescription(room.getShortDescription());
            dto.setLongDescription(room.getLongDescription());
            dto.setMinimumCapacity(room.getMinimumCapacity());
            dto.setMaximumCapacity(room.getMaximumCapacity());
            dto.setIsScary(room.getIsScary());
            dto.setTheme(room.getTheme());
            dto.setImageName(room.getImageName());
            dto.setWebsiteUrl(room.getWebsiteUrl());
            dto.setLocationId(room.getLocation().getId());
            dto.setLocationName(room.getLocation().getName());
            roomsListWithRatingAndCompletedCountDtos.add(dto);
        }
        if(roomsListWithRatingAndCompletedCountDtos.isEmpty()) {
            throw new RoomBusinessException("No rooms with ratings and completed counts found.");
        }
        return roomsListWithRatingAndCompletedCountDtos;
    }

}