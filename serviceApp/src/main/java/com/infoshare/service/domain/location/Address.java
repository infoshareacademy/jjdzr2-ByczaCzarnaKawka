package com.infoshare.service.domain.location;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
public class Address {

    private Long id;
    @NotEmpty(message = "town can't be empty")
    private Town town;
    private String street;

    public Address() {
        this.street = "Unknown";
    }

    public Address(final Town town, final String street) {
        this.town = town;
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address: \n Town: "
                + town
                + ",\n  Road: "
                + street;
    }
}
