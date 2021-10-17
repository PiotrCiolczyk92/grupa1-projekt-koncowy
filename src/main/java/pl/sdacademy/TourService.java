package pl.sdacademy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    public void create(Tour book) {
        if (book.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException("Dodawana wcycieczka nie powinna mieć już istniejącego ID");
            log.error("Wycieczka nie została zapisana", exception);
            throw exception;
        }
        tourRepository.save(book);

    }
}
