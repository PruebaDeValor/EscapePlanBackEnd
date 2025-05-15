package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeGroupRepository;

@Service
public class EscapeGroupServiceImpl implements EscapeGroupService {

    // Aquí puedes implementar los métodos de la interfaz EscapeGroupService
    // utilizando el repositorio correspondiente para acceder a la base de datos.
    @Autowired
    private EscapeGroupRepository escapeGroupRepository;
    
    
    @Transactional(readOnly = true)
    @Override
    public List<EscapeGroup> findAll() {
        return (List<EscapeGroup>) escapeGroupRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<EscapeGroup> findById(Long id) {
        return escapeGroupRepository.findById(id);
    }

    @Transactional
    @Override
    public EscapeGroup save(EscapeGroup escapeGroup) {
        return escapeGroupRepository.save(escapeGroup);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        escapeGroupRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<EscapeGroup> delete(EscapeGroup escapeGroup) {
        Optional<EscapeGroup> escapeGroupOptional = escapeGroupRepository.findById(escapeGroup.getId());
        escapeGroupOptional.ifPresent(escapeGroupDb -> {
            escapeGroupRepository.delete(escapeGroupDb);
        });
        return escapeGroupOptional;
    }

}
