package service;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import domain.location.Town;
import domain.users.Gender;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;


    @Autowired
    public UserService(final UserRepository userRepository,
                final AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    //TODO: temporary solution. Delete after creating the mapping method (DTO <-> Entity) and forms
    @PostConstruct
    public void init(){
        createUsers();
    }

    private void  createUsers(){
        final UserEntity userOne = new UserEntity();
        final AddressEntity userOneAddress= new AddressEntity();
        //final List<SportWithLevelEntity> disciplinesList = new ArrayList<>();
        final SportWithLevelEntity sportWithLevelEntity = new SportWithLevelEntity();

        userOne.setNickname("Anna");
        userOne.setMailAddress("anna@gmail.com");
        userOne.setPassword("qwerty");
        userOne.setBornYear(0);
        userOne.setPhoneNumber("123789456");
        userOne.setGender(Gender.FEMALE);

        userOneAddress.setTown(Town.GDYNIA);
        userOneAddress.setStreetName("ulica 3");

        addressRepository.save(userOneAddress);

        userOne.setAddressEntity(userOneAddress);

        sportWithLevelEntity.setActivityLevel(ActivityLevel.EXPERT);
        sportWithLevelEntity.setSportDiscipline(SportDiscipline.BOXING);

        //disciplinesList.add(sportWithLevelEntity);

        Map<SportDiscipline,SportWithLevelEntity> sportMap = new HashMap<>();
        sportMap.put(SportDiscipline.BOXING,sportWithLevelEntity);
        userOne.setDisciplines(sportMap);

        userRepository.save(userOne);
    }

}
