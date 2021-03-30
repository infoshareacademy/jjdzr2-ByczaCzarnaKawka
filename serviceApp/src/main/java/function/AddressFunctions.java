package function;

import domain.location.Address;
import entity.AddressEntity;


import java.util.function.Function;

public class AddressFunctions {
    public static final Function<AddressEntity, Address> addressEntityToAddress = addressEntity -> new Address(
            addressEntity.getTown(),
            addressEntity.getStreetName()
    );

    public static final Function<Address, AddressEntity> addressToAddressEntity = address -> new AddressEntity(
            address.getTownName(),
            address.getStreetName()
    );
}
