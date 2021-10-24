package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Location;
import pl.sdacademy.repositories.CountryRepository;

import java.util.List;

@Service
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Location> getAll() {
        return countryRepository.findAll();
    }

    public Location getById(int id) {
        return countryRepository.getById(id);
    }

    public void create(Location country) {
        if (country.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawany kraj nie powinien mieć już istniejącego ID");
            log.error("Kraj nie został zapisany", exception);
            throw exception;
        }
        countryRepository.save(country);
    }

    public void update(Location country) {
        if (country.getId() != null) {
            Location updateCountry = countryRepository.getById(country.getId());
            updateCountry.setRegion(country.getRegion());
            updateCountry.setCity(country.getCity());
        }
        countryRepository.save(country);
    }

    public void delete(Location country) {
        if (country.getId() != null) {
            countryRepository.delete(country);
        }
        countryRepository.delete(country);
    }

}
