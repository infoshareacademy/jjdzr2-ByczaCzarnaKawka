package service;

import domain.users.User;
import domain.users.UserDTO;

import entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.UserRepository;

import static function.UserFunctions.*;

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

//    public void saveUser(UserDTO userDTO) {
//        UserEntity user = userDTOToUserEntity.apply(userDTO);
//        userRepository.save(user);
//
//    }

}
