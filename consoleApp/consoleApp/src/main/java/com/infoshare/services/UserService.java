package com.infoshare.services;
import com.infoshare.users.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {


    private Map<String, User> usersMap;

    public UserService() {
        usersMap = new HashMap<>();
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    public void addUser (User user) {
        if (usersMap.containsKey(user.getMailAddress())) {
            System.out.println("Unfortunately the mail address is already exist!");
        } else {
            usersMap.put(user.getMailAddress(), user);
            System.out.println("User successfully added to list!");
        }
    }

    public void printUserList() {
        System.out.println("-----------");
        System.out.println("USERS LIST:");
        System.out.println("----------- \n");

        for (User user : getUsersMap().values()) {
            System.out.println("<<<<<<<<<<<<<<<<");
            user.printBasicInfo();
            System.out.println(">>>>>>>>>>>>>>>>\n");
        }
    }

}

