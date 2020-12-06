package com.infoshare.services;

import com.infoshare.dao.UserRepository;
import com.infoshare.location.Address;
import com.infoshare.tools.Tools;
import com.infoshare.users.Sex;
import com.infoshare.users.User;
import com.infoshare.utils.FileUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserService {

    //TODO add facility filter method, remove method

    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void handleNewUSer() {
        User user = getUserFromConsole();
        saveUser(user);
    }

    private User getUserFromConsole() {
        String nickname = Tools.getFromUser("Podaj imię/nick: ");
        String login = Tools.getLoginFromUser();
        String password = Tools.getPasswordFromUser(); // TODO passwords are written by open text - fix it
        User user = new User(nickname, login, password);
        int age = Tools.getAgeFromUser();
        user.setAge(age);
        String phoneNumber = Tools.getPhoneNumberFromUser();
        user.setPhoneNumber(phoneNumber);
        Sex sex = Tools.getSexFromUser("Podaj płeć: ");
        user.setSex(sex);
        user = Tools.getActivityFromUser(user);
        Address address = Tools.getAddressFromUser();
        user.setAddress(address);
        return user;
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

    }

