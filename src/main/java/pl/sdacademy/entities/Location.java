package pl.sdacademy.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "pole nie może być puste")
    private String country;
    @NotEmpty(message = "pole nie może być puste")
    private String region;
    @NotEmpty(message = "pole nie może być puste")
    private String city;

    public String getFullLocation() {
        return "Kraj: " + country + " / Region: " + region + " / Miasto: " + city;
    }
}
