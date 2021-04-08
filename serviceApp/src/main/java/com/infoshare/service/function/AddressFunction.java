package com.infoshare.service.function;

import com.infoshare.service.domain.location.Address;
import com.infoshare.service.entity.AddressEntity;

import java.util.function.Function;

public class AddressFunction {

    public static final Function<AddressEntity, Address> addressEntityToDto =
            addressEntity -> new Address(
                    addressEntity.getId(),
                    addressEntity.getTown(),
                    addressEntity.getStreetName()
            );

    public static final Function<Address, AddressEntity> addressDtoToEntity =
            address -> new AddressEntity(
                    address.getTown(),
                    address.getStreet()
            );

}
