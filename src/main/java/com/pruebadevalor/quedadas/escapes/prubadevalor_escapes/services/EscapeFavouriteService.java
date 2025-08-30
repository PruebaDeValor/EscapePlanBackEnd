package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeFavourite;

public interface EscapeFavouriteService {

    List<EscapeFavourite> findAll();

    Optional<EscapeFavourite> findById(Long id);

    EscapeFavourite save(EscapeFavourite escapeFavourite);

    EscapeFavourite saveByEscapeIdAndPersonId(Long escapeId, Long personId);

    EscapeFavourite update(Long escapeFavouriteId, EscapeFavourite escapeFavourite);

    void deleteById(Long id);

    Optional<EscapeFavourite> delete(EscapeFavourite escapeFavourite);

    List<EscapeFavourite> findByRoomId(Long escapeId);

    List<EscapeFavourite> findByPerson(Long userId);

    Optional<EscapeFavourite> findByRoomAndPerson(Long roomId, Long personId);
}
