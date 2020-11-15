package com.infoshare.services;

import com.infoshare.dao.UserRepository;
import com.infoshare.location.Address;
import com.infoshare.tools.Tools;
import com.infoshare.users.User;

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

    //TODO separate method logic into single responsibility methods
    private User getUserFromConsole() {
        String nickname = Tools.getFromUser("Podaj imię/nick:");
        String login = Tools.getFromUser("Podaj adres e-mail:");
        login = Tools.veryfityEmail(login);
        // TODO passwords are written by open text - fix it
        String password1 = Tools.getFromUser("Podaj hasło:");
        String password2 = Tools.getFromUser("Powtórz hasło:");
        String password = Tools.veryfityPassword(password1, password2);
        User user = new User(nickname, login, password);

        user.setAge(Tools.getIntFromUser("Ile masz lat:"));

        String phoneNumber = Tools.getFromUser("Podaj nr telefonu:");
        user.setPhoneNumber(Tools.veryfityPhoneNumber(phoneNumber));

        user.setSex(Tools.getSexFromUser("Podaj płeć: "));

        String next;
        do {
            user.addActivity(Tools.getActivityFromUser());
            next = Tools.getFromUser("Chcesz dodoać kolejną dyscyplinę? Y/N ").toUpperCase();
        } while ("Y".equals(next));

        String choice = Tools.getFromUser("Chcesz podać adres zamieszkoania? Y?N").toUpperCase();
        if ("Y".equals(choice)) {
            user.setAddress(new Address(Tools.getTownFromUser("Podaj miasto"), Tools.getRoadFromUser()));
        }

        return user;
    }

    public void saveUser(User user) {
        Map<String, User> usersMap = userRepository.getUsersMap();

        if (usersMap.containsKey(user.getMailAddress())) {
            System.out.println("Unfortunately the mail address is already exist!");
        } else {
            usersMap.put(user.getMailAddress(), user);
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

