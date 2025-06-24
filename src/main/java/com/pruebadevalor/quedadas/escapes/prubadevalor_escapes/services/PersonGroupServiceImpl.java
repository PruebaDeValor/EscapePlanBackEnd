package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup.Role;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup.Status;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

public class PersonGroupServiceImpl implements PersonGroupService {

@Autowired
    private PersonRepository personRepository;

    @Autowired
    private EscapeGroupRepository escapegroupRepository;

    @Autowired
    private PersonGroupRepository personGroupRepository;
    

    @Transactional(readOnly = true)
    @Override
    public List<PersonGroup> findAll() {
        return (List<PersonGroup>) personGroupRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PersonGroup> findById(Long id) {
        return personGroupRepository.findById(id);
    }

    @Override
    public Optional<PersonGroup> findByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId) {
        // Check if person exists
        if (!personRepository.existsById(personId)) {
            return Optional.empty(); // Person does not exist
        }
        // Check if escape group exists
        if (!escapegroupRepository.existsById(escapeGroupId)) {
            return Optional.empty(); // Escape group does not exist
        }
        // If both exist, find the PersonGroup
        // and return it
        // Note: This assumes that the PersonGroupRepository has a method
        // findByPersonIdAndEscapeGroupId
        // that retrieves the PersonGroup based on personId and escapeGroupId.
        // If such a method does not exist, you would need to implement it in the repository.
        // This is a placeholder for the actual repository method call.
        // Assuming the repository method is correctly defined, we can call it directly.
        // If the repository method does not exist, you would need to create it.
        // This method should return an Optional<PersonGroup> based on the personId and escapeGroupId.
        // Check if the personId and escapeGroupId exist in the repository
        if (!personGroupRepository.existsByPersonIdAndEscapeGroupId(personId, escapeGroupId)) {
            return Optional.empty(); // PersonGroup does not exist
        }
        return personGroupRepository.findByPersonIdAndEscapeGroupId(personId, escapeGroupId);
        
    }

    @Override
    public PersonGroup saveByPersonIdEscapeGroupIdRoleAndStatus(Long personId, Long escapeGroupId, Role role,
            Status status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveByPersonIdEscapeGroupIdRoleAndStatus'");
    }

    @Override
    public List<PersonGroup> findByPersonId(Long personId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPersonId'");
    }

    @Override
    public List<PersonGroup> findByEscapeGroupId(Long escapeGroupId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEscapeGroupId'");
    }

    @Override
    public PersonGroup save(PersonGroup personGroup) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Optional<PersonGroup> delete(PersonGroup personGroup) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByPersonIdAndEscapeGroupId'");
    }



}
