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
import java.util.List;

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
        final List<SportWithLevelEntity> disciplinesList = new ArrayList<>();
        final SportWithLevelEntity sportWithLevelEntity = new SportWithLevelEntity();
        final ActivityLevelEntity activityLevelEntity = new ActivityLevelEntity();
        final SportDisciplineEntity sportDisciplineEntity = new SportDisciplineEntity();

        userOne.setNickname("Anna");
        userOne.setMailAddress("anna@gmail.com");
        userOne.setPassword("qwerty");
        userOne.setBornYear(0);
        userOne.setPhoneNumber("159357456");
        userOne.setGender(Gender.FEMALE);

        userOneAddress.setTown(Town.GDANSK);
        userOneAddress.setStreetName("ulica 1");

        addressRepository.save(userOneAddress);

        userOne.setAddressEntity(userOneAddress);

        activityLevelEntity.setActivityLevel(ActivityLevel.EXPERT);
        sportWithLevelEntity.setActivityLevelEntity(activityLevelEntity);

        sportDisciplineEntity.setSportDiscipline(SportDiscipline.BOXING);
        sportWithLevelEntity.setSportDisciplineEntity(sportDisciplineEntity);

        disciplinesList.add(sportWithLevelEntity);

        userOne.setDisciplines(disciplinesList);

        userRepository.save(userOne);
    }

}
