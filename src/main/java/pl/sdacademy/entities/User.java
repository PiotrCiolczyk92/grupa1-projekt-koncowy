package pl.sdacademy.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    @OneToMany
    private Set<Tour> tours;

        public String getFullName(){
            return firstName + " " + lastName;
        }
}
