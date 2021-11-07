package pl.sdacademy.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Setter
@Entity
@Getter
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @Min(value = 0)
    private Integer numberOfParticipants = 0;
    @Min(value = 1)
    private Integer maxNumberOfParticipants;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Airport placeOfArrival;
    @ManyToOne
    private Airport placeOfDeparture;
    private Integer price;
    private boolean available = true;
    @ManyToOne
    private User user;
    @ManyToOne
    private User customer;

    public String getTourInfo() {
        return "Max number of participants: " + maxNumberOfParticipants + " / " + "Destination: " + location +
                " / " + "Price per person: " + price;
    }

}
