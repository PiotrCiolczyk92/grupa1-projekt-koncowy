package pl.sdacademy.entities;

import lombok.Getter;
import lombok.Setter;
import pl.sdacademy.enums.Country;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Country country;
    private String region;
    private String city;

    public String getFullLocation() {
        return "Kraj: " + country + " Region: " + region + " Miasto: " + city;
    }
}
