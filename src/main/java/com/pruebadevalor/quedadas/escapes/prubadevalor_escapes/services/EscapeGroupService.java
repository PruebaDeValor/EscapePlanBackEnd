package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;
import java.util.List;
import java.util.Optional;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;

public interface EscapeGroupService {

    List<EscapeGroup> findAll();

    Optional<EscapeGroup> findById(Long id);

    EscapeGroup save(EscapeGroup escapeGroup);

    void deleteById(Long id);

    Optional<EscapeGroup> delete(EscapeGroup escapeGroup);

}
