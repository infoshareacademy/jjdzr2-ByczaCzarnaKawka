package service;

import domain.activities.SportDiscipline;
import domain.location.Town;
import entity.SportFacilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.SportFacilityRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportFacilityService {

    private final SportFacilityRepository sportFacilityRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public SportFacilityService(final SportFacilityRepository sportFacilityRepository, final AddressRepository addressRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
        this.addressRepository = addressRepository;
    }


    public List<Town> getTown() {
        return Arrays.asList(Town.values());
    }

    public List<SportDiscipline> getSportDiscipline() {
        return Arrays.asList(SportDiscipline.values());
    }


    public List<SportFacilityEntity> findSportFacility(Town town, SportDiscipline sportDiscipline, String club) {
        List<SportFacilityEntity> sportFacilityEntityList = sportFacilityRepository.findAll();

        if (!town.equals(Town.ALL)) {
            sportFacilityEntityList = sportFacilityEntityList.stream()
                    .filter(sportFacilityEntity -> sportFacilityEntity.getAddressEntity().getTown().equals(town))
                    .collect(Collectors.toList());
        }
        if (!sportDiscipline.equals(SportDiscipline.ALL)) {
            sportFacilityEntityList = sportFacilityEntityList.stream()
                    .filter(sportFacilityEntity -> sportFacilityEntity.getSportDiscipline().equals(sportDiscipline))
                    .collect(Collectors.toList());
        }
        if (!club.equals("ALL")) {
            sportFacilityEntityList = sportFacilityEntityList.stream()
                    .filter(sportFacilityEntity -> sportFacilityEntity.getFacilityName().toLowerCase().contains(club.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return sportFacilityEntityList;
    }
}
