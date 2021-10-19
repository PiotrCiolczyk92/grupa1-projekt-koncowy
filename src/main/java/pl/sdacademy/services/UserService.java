package pl.sdacademy.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.sdacademy.entities.User;
import pl.sdacademy.repositories.UserRepository;

import java.util.List;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Integer id) {
        return userRepository.getById(id);
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

    public void update(User user) {
        if (user.getId() != null) {
            User updatedUser = userRepository.getById(user.getId());
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setMobile(user.getMobile());
            updatedUser.setEmail(user.getEmail());
        }
            userRepository.save(user);


    }

    public void delete(User user) {
        if(user.getId() != null) {
            userRepository.delete(user);
        }
    }

}
