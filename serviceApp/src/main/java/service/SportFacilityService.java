package service;

import domain.activities.SportDiscipline;
import domain.location.Town;
import entity.AddressEntity;
import entity.SportDisciplineEntity;
import entity.SportFacilityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.SportDisciplineRepository;
import repository.SportFacilityRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalTime;

@Service
public class SportFacilityService {

    private final SportFacilityRepository sportFacilityRepository;
    private final AddressRepository addressRepository;
    private final SportDisciplineRepository sportDisciplineRepository;

    @Autowired
    public SportFacilityService(final SportFacilityRepository sportFacilityRepository, final AddressRepository addressRepository, final SportDisciplineRepository sportDisciplineRepository) {
        this.sportFacilityRepository = sportFacilityRepository;
        this.addressRepository = addressRepository;
        this.sportDisciplineRepository = sportDisciplineRepository;
    }

    //TODO: temporary solution. Delete after creating the mapping method (DTO <-> Entity) and forms

    @PostConstruct
    public void init(){createSportFacility();}

    private void createSportFacility(){
        final SportFacilityEntity sportFacility1 = new SportFacilityEntity();
        final AddressEntity facilityAddress1 = new AddressEntity();
        final SportDisciplineEntity sportDisciplineEntity = new SportDisciplineEntity();

        //facility 1
        sportFacility1.setFacilityName("Miejska Hala Sportowa");

        sportDisciplineEntity.setSportDiscipline(SportDiscipline.FOOTBALL);
        sportFacility1.setSportDisciplineEntity(sportDisciplineEntity);

        sportFacility1.setPhoneNumber("58 553 27 58");

        facilityAddress1.setTown(Town.GDANSK);
        facilityAddress1.setStreetName("Kołobrzeska 61");
        addressRepository.save(facilityAddress1);

        sportFacility1.setAddressEntity(facilityAddress1);

        sportFacility1.setOpenHour(LocalTime.of(14, 0));
        sportFacility1.setCloseHour(LocalTime.of(20, 0));

        sportFacility1.setPrice(BigDecimal.valueOf(50));
        sportFacilityRepository.save(sportFacility1);

    }
}
