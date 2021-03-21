package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressRepository;
import repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;


    @Autowired
    public UserService(final UserRepository userRepository,
                       final AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

}
