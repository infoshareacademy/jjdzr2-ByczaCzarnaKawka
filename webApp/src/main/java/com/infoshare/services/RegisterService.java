package com.infoshare.services;

import com.infoshare.services.UserConsoleService;
import domain.activities.Activity;
import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import domain.location.Address;
import domain.location.Town;
import domain.users.Gender;
import domain.users.User;
import domain.users.UserDTO;
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
        return new Address(user.getAddress().getTownName(), user.getAddress().getStreetName());
    }

    private List<Activity> createActivityList(UserDTO user) {
        Activity activity = new Activity(user.getSportDisciplines(), user.getActivityLevel());
        return new ArrayList<>(Arrays.asList(activity));
    }
}

