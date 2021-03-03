package com.infoshare.services;

import domain.activities.Activity;
import domain.activities.ActivityLevel;
import domain.activities.SportDiscipline;
import fileDatabase.UserRepository;
import domain.location.Address;
import domain.location.Town;
import com.infoshare.tools.ConsoleTools;
import domain.users.Gender;
import domain.users.User;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConsoleService {

        //TODO add facility filter method, remove method

    private UserRepository userRepository;

    public UserConsoleService() {
        this.userRepository = new UserRepository();
    }

    public void handleNewUSer() {

        System.out.println("Create new user:");
        User user = getUserFromConsole();
        saveUser(user);
    }

    public void saveUser(User user) {
        Map<String, User> usersMap = userRepository.getUsersMap();
       // System.out.println("userMap: " + usersMap);

        if (usersMap.containsKey(user.getMailAddress())) {
            System.out.println("Unfortunately the mail address is already exist!");
        } else {
            usersMap.put(user.getMailAddress(), user);
            System.out.println("userMap: " + usersMap);
            FileUtils.saveUsersToJsonFile(new ArrayList<>(usersMap.values()));

            System.out.println("User successfully added to list!");
        }
    }

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

    //FIXME: czy porównanie robić na pewno tutaj?
    public static ActivityLevel valueOfActivityLabel(String label) {
        for (int i = 0; i < ActivityLevel.values().length; i++) {
            if (ActivityLevel.values()[i].name().equals(label.toUpperCase())) {
                return ActivityLevel.values()[i];
            }
        }
        return ConsoleTools.getActivityLevelFromUser("There's no such a level of activity. Choose one from the following: ");
    }
    private User getUserFromConsole() {
        //FIXME: do przegadania rozbicie na metody
        String nickname = ConsoleTools.getFromUser("Your name: ");
        String login = ConsoleTools.getLoginFromUser();
        String password = ConsoleTools.getPasswordFromUser(); // TODO passwords are written by open text - fix it
        User user = new User(nickname, login, password);
        int age = ConsoleTools.getAgeFromUser();
        user.setBornYear(age);
        String phoneNumber = ConsoleTools.getPhoneNumberFromUser();
        user.setPhoneNumber(phoneNumber);
        Gender gender = ConsoleTools.getGenderFromUser("Your gender: ");
        user.setSex(gender);
        user = ConsoleTools.getActivityFromUser(user);
        Address address = ConsoleTools.getAddressFromUser();
        user.setAddress(address);
        return user;
    }

    public static SportDiscipline valueOfSportDisciplinesLabel(String label) {
        for (int i = 0; i < SportDiscipline.values().length; i++) {
            if (SportDiscipline.values()[i].name().equals(label.toUpperCase())) {
                return SportDiscipline.values()[i];
            }
        }
        return ConsoleTools.getSportDisciplinesFromUser("There's no such an activity. Choose one from the following: ");
    }

    public static Town valueOfTownLabel(String label) {
        for (int i = 0; i < Town.values().length; i++) {
            if (Town.values()[i].name().equals(label.toUpperCase())) {
                return Town.values()[i];
            }
        }
        return ConsoleTools.getTownFromUser("There's no such a Town. Choose one from the following: ");
    }
    public static Gender valueOfGenderLabel(String label) {
        for (int i = 0; i < Gender.values().length; i++) {
            if (Gender.values()[i].name().equals(label.toUpperCase())) {
                return Gender.values()[i];
            }
        }
        return ConsoleTools.getGenderFromUser("Something went wrong, enter your gender: ");
    }

    public void foundUser() {
        Town town = ConsoleTools.getTownFromUser("Choice town to find your game partner: ");
        SportDiscipline sportDiscipline = ConsoleTools.getSportDisciplinesFromUser("Choice sport discipline: ");
        Map<String, User> foundUser;
        foundUser = foundUserInRepository(town, sportDiscipline);
        if (foundUser.isEmpty()) {
            System.out.println("Sorry, no one in " + town + " trains " + sportDiscipline + "\n");
        } else {
            printUserList(foundUser);
        }
    }

    private Map<String, User> foundUserInRepository(Town town, SportDiscipline sportDiscipline) {
        Map<String, User> userFromTown;
        Map<String, User> userPracticingDiscipline;
        userFromTown = foundUserFromTown(town);
        userPracticingDiscipline = foundUsersPracticingDiscipline(userFromTown, sportDiscipline);
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

    private Map<String, User> foundUsersPracticingDiscipline(Map<String, User> player, SportDiscipline sportDiscipline) {
        Map<String, User> mapFound = new HashMap<>();
        List<Activity> listActivity;
        for (String email : player.keySet()) {
            listActivity = player.get(email).getActivityList();
            if (isActivityInList(listActivity, sportDiscipline)) {
                mapFound.put(email, player.get(email));
            }
        }
        return mapFound;
    }

    private boolean isActivityInList(List<Activity> listActivity, SportDiscipline sportDiscipline) {
        for (Activity act : listActivity) {
            if (sportDiscipline.equals(act.getSportDisciplines())) {
                return true;
            }
        }
        return false;
    }
}
