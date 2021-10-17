package pl.sdacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.entities.Tour;

public interface TourRepository extends JpaRepository<Tour, Integer> {

}
