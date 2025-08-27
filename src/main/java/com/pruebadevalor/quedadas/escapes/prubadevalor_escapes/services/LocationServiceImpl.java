package com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.entities.Location;
import com.pruebadevalor.quedadas.escapes.prubadevalor_escapes.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{


    @Autowired
    private LocationRepository locationRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Location> findAll() {
        if (locationRepository == null) {
            throw new LocationBusinessException("Location repository is not initialized");
        }
        return (List<Location>) locationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Location> findById(Long id) {
        if(id == null) {
            throw new LocationBusinessException("Location ID cannot be null");
        }
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (!optionalLocation.isPresent()) {
            throw new LocationBusinessException("Location with ID " + id + " does not exist.");
        }
        return optionalLocation;
    }

    @Transactional
    @Override
    public Location save(Location location) {
        if (location.getName() == null || location.getName().isEmpty()) {
            throw new LocationBusinessException("Location name cannot be null or empty");
        }
    
        return locationRepository.save(location);
    }

    @Transactional
    @Override
    public Optional<Location> deleteById(Long id) {
        Optional<Location> optionalLocation = locationRepository.findById(id);
        if (optionalLocation.isEmpty()) {
            throw new LocationBusinessException("Location with ID " + id + " does not exist.");
        }
        locationRepository.deleteById(id);
        return optionalLocation; // Return the deleted location
        
    }

    @Transactional
    @Override
    public Optional<Location> delete(Location location) {
        if (location == null || location.getId() == null) {
            throw new LocationBusinessException("Location cannot be null and must have an ID");
        }

        Optional<Location> locationOptional = locationRepository.findById(location.getId());
        if (!locationOptional.isPresent()){
            throw new LocationBusinessException("Location with ID " +
            location.getId() + " does not exist.");
        }
            locationRepository.delete(location);
            return locationOptional;
    };
        
    

    @Transactional(readOnly = true)
    @Override
    public Optional<Location> findByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new LocationBusinessException("Location name cannot be null or empty");
        }
        Optional<Location> optionalLocation = locationRepository.findByName(name);
        if (!optionalLocation.isPresent()) {
            throw new LocationBusinessException("Location with name " + name + " does not exist.");
        }
        return optionalLocation;
    }
    
    // Excepción general para lógica de negocio de Location
    public static class LocationBusinessException extends RuntimeException {
        public LocationBusinessException(String message) {
            super(message);
        }
    }
}
