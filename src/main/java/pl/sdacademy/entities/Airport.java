package pl.sdacademy.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Airport name should be given.")
    @Size(min = 2, max = 50, message = "The number of characters must be between 5 and 20")
    private String name;
    @OneToOne
    private Location location;

    public String airportDetail() {
        return "Kraj: " + location.getCountry();
    }

}
