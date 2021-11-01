package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Airport;
import pl.sdacademy.entities.Tour;
import pl.sdacademy.repositories.AriportRepository;

import java.util.List;

@Service
@Slf4j
public class AirportService {

    private AriportRepository ariportRepository;

    private AirportService(AriportRepository ariportRepository) {
        this.ariportRepository = ariportRepository;
    }

    public List<Airport> getAll() {
        return ariportRepository.findAll();
    }

    public Airport getById(Integer id) {
        return ariportRepository.getById(id);
    }

    public void create(Airport airport) {
        if (airport.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawane lotnisko nie powinno mieć już istniejącego ID");
            log.error("Lotnisko nie zostało zapisane", exception);
            throw exception;
        }
        ariportRepository.save(airport);
    }
}
