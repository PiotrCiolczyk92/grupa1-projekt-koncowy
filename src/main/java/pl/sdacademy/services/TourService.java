package pl.sdacademy.services;



import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.Tour;
import pl.sdacademy.repositories.TourRepository;

import java.util.List;


@Service
@Slf4j
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> getAll() {
        return tourRepository.findAll();
    }

    public void create(Tour tour) {
        if (tour.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawana wcycieczka nie powinna mieć już istniejącego ID");
            log.error("Wycieczka nie została zapisana", exception);
            throw exception;
        }
        tourRepository.save(tour);

    }

    public void delete(Tour tour) {
        if (!tour.isAvailable()) {
            tourRepository.deleteById(tour.getId());
        }

    }


}
