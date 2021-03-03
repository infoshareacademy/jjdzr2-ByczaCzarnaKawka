package entities;

import domain.location.Town;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Town town;

    private String streetName;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    Town getTown() {
        return town;
    }

    void setTown(final Town town) {
        this.town = town;
    }

    String getStreetName() {
        return streetName;
    }

    void setStreetName(final String streetName) {
        this.streetName = streetName;
    }
}
