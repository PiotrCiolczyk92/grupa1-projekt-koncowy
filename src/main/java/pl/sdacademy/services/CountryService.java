package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Country;
import pl.sdacademy.entities.Tour;
import pl.sdacademy.repositories.CountryRepository;

import java.util.List;

@Service
@Slf4j
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public void create(Country country) {
        if (country.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawany kraj nie powinien mieć już istniejącego ID");
            log.error("Kraj nie został zapisany", exception);
            throw exception;
        }
        countryRepository.save(country);

    }
}
