package pl.sdacademy;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numberOfParticipants;
    private String country;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public Integer getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPrice() {
        return price;
    }
}
