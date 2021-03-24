package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.SportFacilityRepository;

@Service
public class SportFacilityService {

    private final SportFacilityRepository sportFacilityRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public SportFacilityService(final SportFacilityRepository sportFacilityRepository, final AddressRepository addressRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
        this.addressRepository = addressRepository;
    }

}
