package pl.sdacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.entities.Airport;

public interface AriportRepository extends JpaRepository<Airport, Integer> {
}
