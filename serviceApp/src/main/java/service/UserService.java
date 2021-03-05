package service;

import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import domain.location.Town;
import domain.users.Gender;
import entity.AddressEntity;
import entity.DisciplineWithLevelEntity;
import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.DisciplinesWIthLevelsRepository;
import repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final DisciplinesWIthLevelsRepository disciplinesWIthLevelsRepository;

    @Autowired
    UserService(final UserRepository userRepository,
                final AddressRepository addressRepository,
                final DisciplinesWIthLevelsRepository disciplinesWIthLevelsRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.disciplinesWIthLevelsRepository = disciplinesWIthLevelsRepository;
    }

    //TODO: temporary solution. Delete after creating  the mapping method (DTO <-> Entity)
    @PostConstruct
    public void init(){
        createUsers();
    }

    private void  createUsers(){
        final UserEntity userOne = new UserEntity();
        final AddressEntity userOneAddress= new AddressEntity();
        final Set<DisciplineWithLevelEntity> userOneHobbies = new HashSet<>();
        final DisciplineWithLevelEntity discWithLevelOne;

        userOne.setNickname("Jan");
        userOne.setMailAddress("kowalski@gmail.com");
        userOne.setPassword("qwerty");
        userOne.setBornYear(0);
        userOne.setPhoneNumber("147258369");
        userOne.setGender(Gender.MALE);

        userOneAddress.setTown(Town.GDANSK);
        userOneAddress.setStreetName("ulica 1");
        addressRepository.save(userOneAddress);

        userOne.setAddressEntity(userOneAddress);

        discWithLevelOne = disciplinesWIthLevelsRepository.
                getByActivityLevelAndSportDiscipline(ActivityLevel.INTERMEDIATE,SportDiscipline.BOXING);

        userOneHobbies.add(discWithLevelOne);

        userOne.setDisciplinesWithLevels(userOneHobbies);

        userRepository.save(userOne);
    }

}
