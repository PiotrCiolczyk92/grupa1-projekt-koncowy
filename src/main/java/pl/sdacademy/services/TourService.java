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

    public Tour getById(Integer id) {
        return tourRepository.getById(id);
    }

    public void create(Tour tour) {
        if (tour.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawana wcycieczka nie powinna mieć już istniejącego ID");
            log.error("Wycieczka nie została zapisana", exception);
            throw exception;
        }
        tour.setAvailable(true);
        tourRepository.save(tour);
    }

    public void update(Tour tour) {
            //Obsługa żądania metodą POST (nie potrzebujemy już id przekazywać w ścieżce lub url)
        // sprawdzi, czy jest zadany id - jeśli tak, to aktualizujemy, jeśli nie, to dodajemy
        if (tour.getId() != null) {
            Tour updatedTour = tourRepository.getById(tour.getId());
            updatedTour.setPrice(tour.getPrice());
            updatedTour.setNumberOfParticipants(tour.getNumberOfParticipants());
            updatedTour.setLocation(tour.getLocation());
        }
            tourRepository.save(tour);
    }

    public void delete(Tour tour) {
        if (tour.getId() != null) {
            tourRepository.delete(tour);
        }
    }


}
