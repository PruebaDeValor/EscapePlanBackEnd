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
        return (List<Location>) locationRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Transactional
    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Optional<Location> delete(Location location) {
        Optional<Location> locationOptional = locationRepository.findById(location.getId());
        locationOptional.ifPresent(locationDb -> {
            locationRepository.delete(locationDb);
        });
        return locationOptional;
    }
    
    
}
