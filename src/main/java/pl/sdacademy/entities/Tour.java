package pl.sdacademy.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Entity
@Getter
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfParticipants;
    private String country;
    private Integer price;
    private boolean available = true;

}
