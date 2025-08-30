package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeFavourite;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeFavouriteRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@Service
public class EscapeFavouriteServiceImpl implements EscapeFavouriteService {

    @Autowired
    private EscapeFavouriteRepository escapeFavouriteRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<EscapeFavourite> findAll() {
        return (List<EscapeFavourite>) escapeFavouriteRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<EscapeFavourite> findById(Long id) {
        return escapeFavouriteRepository.findById(id);
    }

    @Transactional
    @Override
    public EscapeFavourite save(EscapeFavourite escapeFavourite) {
        Room room = escapeFavourite.getRoom();
        Person person = escapeFavourite.getPerson();
        Optional<EscapeFavourite> escapeFavouriteExist = escapeFavouriteRepository.findByRoomAndPerson(room, person);
        if (escapeFavouriteExist.isPresent()) {
            throw new EscapeFavouriteBusinessException("El escape ya está en favoritos para este usuario.");
        }
        return escapeFavouriteRepository.save(escapeFavourite);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        escapeFavouriteRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<EscapeFavourite> delete(EscapeFavourite escapeFavourite) {
        Optional<EscapeFavourite> escapeFavouriteOptional = escapeFavouriteRepository.findById(escapeFavourite.getId());
        escapeFavouriteOptional.ifPresent(escapeFavouriteDb -> {
            escapeFavouriteRepository.delete(escapeFavouriteDb);
        });
        return escapeFavouriteOptional;
    }

@Transactional(readOnly = true)
@Override
public List<EscapeFavourite> findByPerson(Long userId) {
    Optional<Person> personOptional = personRepository.findById(userId);
    if (!personOptional.isPresent()) {
        throw new EscapeFavouriteBusinessException("No se encontró la persona con id " + userId);
    }
    List<EscapeFavourite> favouritesWithThisPerson = escapeFavouriteRepository.findByPerson(personOptional.get());
    if(favouritesWithThisPerson.isEmpty()) {
        throw new EscapeFavouriteBusinessException("No se encontraron favoritos para la persona con id " + userId);
    }
    return favouritesWithThisPerson;
}

@Transactional(readOnly = true)
@Override
public List<EscapeFavourite> findByRoomId(Long escapeId) {
    Optional<Room> roomOptional = roomRepository.findById(escapeId);
    if (!roomOptional.isPresent()) {
        throw new EscapeFavouriteBusinessException("No se encontró la sala con id " + escapeId);
    }
    List<EscapeFavourite> favouritesWithThisRoom = escapeFavouriteRepository.findByRoom(roomOptional.get());
    if(favouritesWithThisRoom.isEmpty()) {
        throw new EscapeFavouriteBusinessException("No se encontraron favoritos para la sala con id " + escapeId);
    }
    return favouritesWithThisRoom;

}

@Transactional(readOnly = true)
@Override
public Optional<EscapeFavourite> findByRoomAndPerson(Long roomId, Long personId){
    Optional<Room> optionalRoom = roomRepository.findById(roomId);
    if (!optionalRoom.isPresent()) {
        throw new EscapeFavouriteBusinessException("Room with ID " + roomId + " does not exist.");
    }
    Optional<Person> optionalPerson = personRepository.findById(personId);
    if (!optionalPerson.isPresent()) {
        throw new EscapeFavouriteBusinessException("Person with ID " + personId + " does not exist.");
    }
    Optional<EscapeFavourite> optionalEscapeFavourite= escapeFavouriteRepository.findByRoomAndPerson(optionalRoom.get(), optionalPerson.get());
    if(!optionalEscapeFavourite.isPresent()){
        throw new EscapeFavouriteBusinessException("No se encontró el favorito para la sala con ID " + roomId + " y la persona con ID " + personId);
    }
    return optionalEscapeFavourite;
}

@Transactional
@Override
public EscapeFavourite saveByEscapeIdAndPersonId(Long escapeId, Long personId) {
    Optional<Room> optionalRoom = roomRepository.findById(escapeId);
    if (!optionalRoom.isPresent()) {
        throw new EscapeFavouriteBusinessException("Room with ID " + escapeId + " does not exist.");
    }
    Optional<Person> optionalPerson = personRepository.findById(personId);
    if (!optionalPerson.isPresent()) {
        throw new EscapeFavouriteBusinessException("Person with ID " + personId + " does not exist.");
    }
    Optional<EscapeFavourite> optionalEscapeFavourite = escapeFavouriteRepository.findByRoomAndPerson(optionalRoom.get(), optionalPerson.get());
    if (optionalEscapeFavourite.isPresent()) {
        throw new EscapeFavouriteBusinessException("Escape favourite already exists for room ID " + escapeId + " and person ID " + personId);
    }
    EscapeFavourite escapeFavourite = new EscapeFavourite();
    escapeFavourite.setRoom(optionalRoom.get());
    escapeFavourite.setPerson(optionalPerson.get());
    return escapeFavouriteRepository.save(escapeFavourite);
}

@Transactional
@Override
public EscapeFavourite update(Long escapeFavouriteId, EscapeFavourite escapeFavourite) {
    Optional<EscapeFavourite> optionalEscapeFavourite = escapeFavouriteRepository.findById(escapeFavouriteId);
    if (!optionalEscapeFavourite.isPresent()) {
        throw new EscapeFavouriteBusinessException("Escape favourite with ID " + escapeFavouriteId + " does not exist.");
    }
    // Comprobar si ya existe otro favorito con la misma combinación de Room y Person
    Optional<EscapeFavourite> duplicate = escapeFavouriteRepository.findByRoomAndPerson(
        escapeFavourite.getRoom(), escapeFavourite.getPerson()
    );
    if (duplicate.isPresent() && !duplicate.get().getId().equals(escapeFavouriteId)) {
        throw new EscapeFavouriteBusinessException("Ya existe un favorito para esta sala y persona.");
    }
    escapeFavourite.setId(escapeFavouriteId);
    return escapeFavouriteRepository.save(escapeFavourite);
}


public class EscapeFavouriteBusinessException extends RuntimeException {
    public EscapeFavouriteBusinessException(String message) {
        super(message);
    }
}

}