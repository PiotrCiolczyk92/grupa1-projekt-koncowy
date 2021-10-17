package pl.sdacademy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sdacademy.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
