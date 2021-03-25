package com.infoshare.service.domain.location;

import javax.validation.constraints.NotEmpty;

public class Address {
    @NotEmpty(message = "town can't be empty")
    private Town townName;
    private String streetName;

    public Address() {
       // this.townName = Town.UNKNOWN;
        this.streetName = "Unknown";
    }

    public Address(Town townName, String streetName) {
        this.townName = townName;
        this.streetName = streetName;
    }

    public Town getTownName() {
        return townName;
    }

    public String getStreetName() {
        return streetName;
    }
    @Override
    public String toString() {
        return "Address: \n Town: "
                + townName
                + ",\n  Road: "
                + streetName;
    }
}
