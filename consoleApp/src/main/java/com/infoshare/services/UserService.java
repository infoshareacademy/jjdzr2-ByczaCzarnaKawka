package com.infoshare.services;

import com.infoshare.activities.ActivityLevel;
import com.infoshare.dao.UserRepository;
import com.infoshare.location.Address;
import com.infoshare.location.Town;
import com.infoshare.tools.Tools;
import com.infoshare.users.Gender;
import com.infoshare.users.User;
import com.infoshare.utils.FileUtils;


import java.util.ArrayList;
import java.util.Map;

public class UserService {

    //TODO add facility filter method, remove method

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void handleNewUSer() {
        System.out.println("Create new user:");
        User user = getUserFromConsole();
        saveUser(user);
    }



    public void saveUser(User user) {
        Map<String, User> usersMap = userRepository.getUsersMap();
        System.out.println("userMap: " + usersMap);

        if (usersMap.containsKey(user.getMailAddress())) {
            System.out.println("Unfortunately the mail address is already exist!");
        } else {
            usersMap.put(user.getMailAddress(), user);
            System.out.println("userMap: " + usersMap);
            FileUtils.saveUsersToJsonFile(new ArrayList<>(usersMap.values()));

            System.out.println("User successfully added to list!");
        }


    }

    public void printUserList() {
        Map<String, User> usersMap = userRepository.getUsersMap();

        System.out.println("-----------");
        System.out.println("USERS LIST:");
        System.out.println("----------- \n");

        for (User user : usersMap.values()) {
            System.out.println("<<<<<<<<<<<<<<<<");
            user.printBasicInfo();
            System.out.println(">>>>>>>>>>>>>>>>\n");
        }
    }
    //FIXME: czy porównanie robić na pewno tutaj?
    public static ActivityLevel valueOfActivityLabel(String label) {
        for (int i = 0; i < ActivityLevel.values().length; i++) {
            if (ActivityLevel.values()[i].name().equals(label.toUpperCase())) {
                return ActivityLevel.values()[i];
            }
        }
        return Tools.getActivityLevelFromUser("There's no such a level of activity. Choose one from the following: ");
    }
    private User getUserFromConsole() {
        //FIXME: do przegadania rozbicie na metody
        String nickname = Tools.getFromUser("Your name: ");
        String login = Tools.getLoginFromUser();
        String password = Tools.getPasswordFromUser(); // TODO passwords are written by open text - fix it
        User user = new User(nickname, login, password);
        int age = Tools.getAgeFromUser();
        user.setAge(age);
        String phoneNumber = Tools.getPhoneNumberFromUser();
        user.setPhoneNumber(phoneNumber);
        Gender gender = Tools.getGenderFromUser("Your gender: ");
        user.setSex(gender);
        user = Tools.getActivityFromUser(user);
        Address address = Tools.getAddressFromUser();
        user.setAddress(address);
        return user;
    }

    public static Town valueOfTownLabel(String label) {
        for (int i = 0; i < Town.values().length; i++) {
            if (Town.values()[i].name().equals(label.toUpperCase())) {
                return Town.values()[i];
            }
        }
        return Tools.getTownFromUser("There's no such a Town. Choose one from the following: ");
    }
    public static Gender valueOfGenderLabel(String label) {
        for (int i = 0; i < Gender.values().length; i++) {
            if (Gender.values()[i].name().equals(label.toUpperCase())) {
                return Gender.values()[i];
            }
        }
        return Tools.getGenderFromUser("Something went wrong, enter your gender: ");
    }
    }

