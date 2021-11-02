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
