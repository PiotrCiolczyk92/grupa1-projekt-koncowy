package pl.sdacademy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void create(User user) {
        if (user.getId() != null) {
            IllegalArgumentException exception = new IllegalArgumentException(
                    "Dodawany użytkownik nie powinien mieć istniejącego ID");
            log.error("Użytkownik nie został zapisany", exception);
            throw exception;
        }
        userRepository.save(user);

    }
}
