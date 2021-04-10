package com.infoshare.service.service.json;

import com.infoshare.service.domain.users.User;
import com.infoshare.service.domain.users.UserDTO;
import com.infoshare.service.repository.json.UserRepository;
import com.infoshare.service.utils.FileUtils;
import com.infoshare.service.utils.UserUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Component("userServiceJson")
public class UserService {

    private final UserRepository userRepository = new UserRepository();

    //todo: implement login function, for now it's a random user, if any exists
    private Optional<String> currentUserEmail
            = userRepository.getUsersMap().values().stream().findAny().map(User::getMailAddress);

    //todo: implement login function, for now it's a random user, if any exists
    public Optional<User> getCurrentUser() {
        return currentUserEmail.map(email -> userRepository.getUsersMap().get(email));
    }

    //todo: implement logout function
    public void logOut() {
        currentUserEmail = Optional.empty();
    }

    public UserDTO convertToDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setNickname(user.getNickname());
        dto.setMailAddress(user.getMailAddress());
        dto.setPassword(user.getPassword());
        dto.setRepeatPassword(user.getPassword());
        dto.setBornYear(user.getBornYear());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setGender(user.getGender());
        dto.setAddress(user.getAddress());
        dto.setSportDiscipline(user.getActivityList().get(0).getSportDisciplines());
        dto.setActivityLevel(user.getActivityList().get(0).getActivityLevel());

        return dto;
    }

    public void updateUser(UserDTO userDto) {
        Map<String, User> usersMap = userRepository.getUsersMap();

        User user = new UserUtils().createUser(userDto);
        usersMap.put(user.getMailAddress(), user);
        FileUtils.saveUsersToJsonFile(new ArrayList<>(usersMap.values()));
    }

    public void deleteUser(String mailAddress) {
        Map<String, User> usersMap = userRepository.getUsersMap();
        usersMap.remove(mailAddress);
        FileUtils.saveUsersToJsonFile(new ArrayList<>(usersMap.values()));
    }
}
