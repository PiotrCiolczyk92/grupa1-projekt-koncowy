package pl.sdacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
