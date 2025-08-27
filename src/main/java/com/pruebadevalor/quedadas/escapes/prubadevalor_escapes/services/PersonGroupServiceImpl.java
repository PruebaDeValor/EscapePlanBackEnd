package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.EscapeGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Person;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup.Role;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.PersonGroup.Status;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.EscapeGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonGroupRepository;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.PersonRepository;

@Service
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
        if (!personGroupRepository.existsById(id)) {
            throw new PersonGroupBusinessException("PersonGroup with ID " + id + " does not exist.");
        }
        return personGroupRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
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
    public PersonGroup saveByPersonIdEscapeGroupIdRoleAndStatus(Long personId, Long escapeGroupId,
     Role role, Status status) {
        // Check if person exists
        if (!personRepository.existsById(personId)) {
            throw new PersonGroupBusinessException("Person with ID " + personId + " does not exist.");
        }
        // Check if escape group exists
        if (!escapegroupRepository.existsById(escapeGroupId)) {
            throw new PersonGroupBusinessException("Escape group with ID " + escapeGroupId + " does not exist.");
        }
        // Create a new PersonGroup instance
        PersonGroup personGroup = new PersonGroup();
        Person person = personRepository.findById(personId)
                .orElseThrow(
                    () -> new PersonGroupBusinessException(
                        "Person with ID " + personId + " does not exist."));
        
        EscapeGroup escapeGroup = escapegroupRepository.findById(escapeGroupId)
                .orElseThrow(
                    () -> new PersonGroupBusinessException(
                        "Escape group with ID " + escapeGroupId + " does not exist."));
        // Ensure that the role is not null
        if (role == null) {
            role = Role.CANDIDATE; // Default role if not provided
        }
        // Ensure that the status is not null
        if (status == null) {
            throw new PersonGroupBusinessException("Status cannot be null.");
        }

        // Set the properties of the PersonGroup
        personGroup.setPerson(person);
        personGroup.setEscapeGroup(escapeGroup);
        personGroup.setRegistrationDate(LocalDate.now());
        personGroup.setRole(role);
        personGroup.setStatus(status);
        // Save the PersonGroup instance
        PersonGroup personGroupResult= personGroupRepository.save(personGroup);
        // Return the saved PersonGroup instance
        return personGroupResult;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonGroup> findAllByPersonId(Long personId) {
        // Check if person exists
        if (!personRepository.existsById(personId)) {
            return List.of(); // Return an empty list if person does not exist
        }
        // If person exists, find all PersonGroups by personId
        return personGroupRepository.findAllByPersonId(personId);
    }

    @Override
    @Transactional(readOnly = true)
public List<PersonGroup> findByEscapeGroupId(Long escapeGroupId) {
    EscapeGroup escapeGroup = escapegroupRepository.findById(escapeGroupId)
            .orElseThrow(() -> new PersonGroupBusinessException(
                "Escape group with ID " + escapeGroupId + " does not exist."));
    return personGroupRepository.findAllByEscapeGroup(escapeGroup);
}

    @Override
    public PersonGroup save(PersonGroup personGroup) {
        return personGroupRepository.save(personGroup);
    }

    @Override
    @Transactional
    public Optional<PersonGroup> deleteById(Long id) {
        if (!personGroupRepository.existsById(id)) {
            throw new PersonGroupBusinessException("PersonGroup with ID " + id + " does not exist.");
        }
        Optional<PersonGroup> personGroupOptional = personGroupRepository.findById(id);
        if (personGroupOptional.isPresent()) {
            personGroupRepository.deleteById(id);
            return personGroupOptional;
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<PersonGroup> delete(PersonGroup personGroup) {
        Optional<PersonGroup> optionalPersonGroup = personGroupRepository.findById(personGroup.getId());
        if (optionalPersonGroup.isPresent()) {
            personGroupRepository.delete(personGroup);
            return optionalPersonGroup;
        }
        return Optional.empty();
    }

    @Override
    
    public Optional<PersonGroup> deleteByPersonIdAndEscapeGroupId(Long personId, Long escapeGroupId) {
        // Check if person exists
        if (!personRepository.existsById(personId)) {
            throw new PersonGroupBusinessException("Person with ID " + personId + " does not exist.");
        }
        // Check if escape group exists
        if (!escapegroupRepository.existsById(escapeGroupId)) {
            throw new PersonGroupBusinessException("Escape group with ID " + escapeGroupId + " does not exist.");
        }
        // Check if PersonGroup exists
        Optional<PersonGroup> personGroupOptional = personGroupRepository.findByPersonIdAndEscapeGroupId(personId, escapeGroupId);
        if (personGroupOptional.isEmpty()) {
            throw new PersonGroupBusinessException("PersonGroup with personId " + personId + " and escapeGroupId " + escapeGroupId + " does not exist.");
        }
        // If all checks pass, delete the PersonGroup
        personGroupRepository.delete(personGroupOptional.get());
        return personGroupOptional;
    }

    public class PersonGroupBusinessException extends RuntimeException {
        public PersonGroupBusinessException(String message) {
            super(message);
        }
    }



}
