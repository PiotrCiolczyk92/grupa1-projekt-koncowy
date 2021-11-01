package pl.sdacademy.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Country country;
    private String region;
    private String city;

    public String getFullLocation() {
        return "Kraj: " + country + " Region: " + region + " Miasto: " + city;
    }
}
