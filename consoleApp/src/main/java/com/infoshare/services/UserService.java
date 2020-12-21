package com.infoshare.services;

import com.infoshare.activities.Activity;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.dao.UserRepository;
import com.infoshare.location.Address;
import com.infoshare.location.Town;
import com.infoshare.tools.Tools;
import com.infoshare.users.Sex;
import com.infoshare.users.User;
import com.infoshare.utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    //TODO add facility filter method, remove method

    private UserRepository userRepository;

    private final String userListHeader =
            "----------- \n USERS LIST: \n----------- ";

    public void printUserList() {
        Map<String, User> usersMap = userRepository.getUsersMap();
        System.out.println(userListHeader);
        printMap(usersMap);
    }

    public void printUserList(Map<String, User> map) {
        System.out.println(userListHeader);
        printMap(map);
    }

    private void printMap(Map<String, User> map) {
        for (User user : map.values()) {
            System.out.println("<<<<<<<<<<<<<<<<");
            user.printBasicInfo();
            System.out.println(">>>>>>>>>>>>>>>>\n");
        }
    }

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public void handleNewUSer() {
        User user = getUserFromConsole();
        saveUser(user);
    }

    private User getUserFromConsole() {
        String nickname = Tools.getFromUser("Name/nick: ");
        String login = Tools.getLoginFromUser();
        String password = Tools.getPasswordFromUser(); // TODO passwords are written by open text - fix it
        User user = new User(nickname, login, password);
        int age = Tools.getAgeFromUser();
        user.setAge(age);
        String phoneNumber = Tools.getPhoneNumberFromUser();
        user.setPhoneNumber(phoneNumber);
        Sex sex = Tools.getSexFromUser("Sex: ");
        user.setSex(sex);
        user = Tools.getActivityFromUser(user);
        Address address = Tools.getAddressFromUser();
        user.setAddress(address);
        return user;
    }

    private void saveUser(User user) {
        Map<String, User> usersMap = userRepository.getUsersMap();
        String mail = user.getMailAddress();
        usersMap.put(mail, user);
        FileUtils.saveUsersToJsonFile(new ArrayList<>(usersMap.values()));
        System.out.println("User successfully added to list!");
    }

    public void foundUser() {
        Town town = Tools.getTownFromUser("Choice town to find your game partner: ");
        SportDisciplines sportDiscipline = Tools.getSportDisciplinesFromUser("Choice sport discipline: ");
        Map<String, User> foundUser;
        foundUser = foundUserInRepository(town, sportDiscipline);
        if (foundUser.isEmpty()) {
            System.out.println("Sorry, no one in " + town + " trains " + sportDiscipline + "\n");
        } else {
            printUserList(foundUser);
        }
    }

    private Map<String, User> foundUserInRepository(Town town, SportDisciplines sportDisciplines) {
        Map<String, User> userFromTown;
        Map<String, User> userPracticingDiscipline;
        userFromTown = foundUserFromTown(town);
        userPracticingDiscipline = foundUsersPracticingDiscipline(userFromTown, sportDisciplines);
        return userPracticingDiscipline;
    }

    private Map<String, User> foundUserFromTown(Town town) {
        Map<String, User> mapFound = new HashMap<>();
        Town checkTown;
        for (String email : userRepository.getUsersMap().keySet()) {
            checkTown = userRepository.getUsersMap().get(email).getAddress().getTownName();
            if (town.equals(checkTown)) {
                mapFound.put(email, userRepository.getUsersMap().get(email));
            }
        }
        return mapFound;
    }

    private Map<String, User> foundUsersPracticingDiscipline(Map<String, User> player, SportDisciplines sportDisciplines) {
        Map<String, User> mapFound = new HashMap<>();
        List<Activity> listActivity;
        for (String email : player.keySet()) {
            listActivity = player.get(email).getActivityList();
            if (isActivityInList(listActivity, sportDisciplines)) {
                mapFound.put(email, player.get(email));
            }
        }
        return mapFound;
    }

    private boolean isActivityInList(List<Activity> listActivity, SportDisciplines sportDisciplines) {
        for (Activity act : listActivity) {
            if (sportDisciplines.equals(act.getSportDisciplines())) {
                return true;
            }
        }
        return false;
    }
}