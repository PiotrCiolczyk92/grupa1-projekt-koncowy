package pl.sdacademy.entities;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
