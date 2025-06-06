package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeFavourite;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Room;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeFavouriteRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@Service
public class EscapeFavouriteServiceImpl implements EscapeFavouriteService {

    @Autowired
    private EscapeFavouriteRepository escapeFavouriteRepository;
    private PersonRepository personRepository;
    private RoomRepository roomRepository;

    EscapeFavouriteServiceImpl(RoomRepository roomRepository) {
    }

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
    return personRepository.findById(userId)
        .map(person -> escapeFavouriteRepository.findByPerson(person))
        .orElse(List.of());
}

@Transactional(readOnly = true)
@Override
public Optional<EscapeFavourite> findByRoomId(Long escapeId) {
    Optional<Room> roomOptional = roomRepository.findById(escapeId);
    if (roomOptional.isPresent()) {
        return escapeFavouriteRepository.findByRoom(roomOptional.get());
    }
    return Optional.empty();

}

    
}
