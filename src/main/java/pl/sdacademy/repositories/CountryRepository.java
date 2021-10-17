package pl.sdacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
