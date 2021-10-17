package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Country;
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
}
