package com.infoshare.service.service.json;


import com.infoshare.service.service.console.UserConsoleService;
import com.infoshare.service.domain.activities.Activity;
import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Address;
import com.infoshare.service.domain.location.Town;
import com.infoshare.service.domain.users.Gender;
import com.infoshare.service.domain.users.User;
import com.infoshare.service.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RegisterService {

    public List<Town> getTownName() {
        return Arrays.asList(Town.values());
    }

    public List<Gender> getUserGender() {
        return Arrays.asList(Gender.values());
    }

    public List<SportDiscipline> getUserSportDiscipline() {
        return Arrays.asList(SportDiscipline.values());
    }

    public List<ActivityLevel> getUserActivityLevels() {
        return Arrays.asList(ActivityLevel.values());
    }


    public void saveNewUser(UserDTO user) {
        User newUser = createUser(user);
        UserConsoleService userConsoleService = new UserConsoleService();
        userConsoleService.saveUser(newUser);
    }

    private User createUser(UserDTO user) {
        Address address = createAddress(user);
        List<Activity> activities = createActivityList(user);
        return new User(user.getNickname(), user.getMailAddress(), user.getPassword(), user.getBornYear(), user.getPhoneNumber(), user.getGender(), address, activities);
    }

    private Address createAddress(UserDTO user) {
        return new Address(user.getAddress().getTown(), user.getAddress().getStreet());
    }

    private List<Activity> createActivityList(UserDTO user) {
        Activity activity = new Activity(user.getSportDiscipline(), user.getActivityLevel());
        return new ArrayList<>(Arrays.asList(activity));
    }
}

