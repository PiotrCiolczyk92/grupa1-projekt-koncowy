package pl.sdacademy;


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

    public void setNumberOfParticipants(Integer numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
