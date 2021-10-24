package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Location;
import pl.sdacademy.repositories.LocationRepository;

import java.util.List;

@Service
@Slf4j
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public Location getById(int id) {
        return locationRepository.getById(id);
    }

    public void create(Location location) {
        if (location.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawany lokacja nie powinien mieć już istniejącego ID");
            log.error("Kraj nie został zapisany", exception);
            throw exception;
        }
        locationRepository.save(location);
    }

    public void update(Location location) {
        if (location.getId() != null) {
            Location updateLocation = locationRepository.getById(location.getId());
            updateLocation.setRegion(location.getRegion());
            updateLocation.setCity(location.getCity());
        }
        locationRepository.save(location);
    }

    public void delete(Location location) {
        if (location.getId() != null) {
            locationRepository.delete(location);
        }
        locationRepository.delete(location);
    }

}
