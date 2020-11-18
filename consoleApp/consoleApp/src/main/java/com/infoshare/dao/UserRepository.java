package com.infoshare.dao;

import com.infoshare.activities.Activity;
import com.infoshare.activities.ActivityLevel;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.users.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private Map<String, User> usersMap;

    public UserRepository() {
        this.usersMap = new HashMap<>();
        prepareData();
    }

    public Map<String, User> getUsersMap() {
        return usersMap;
    }

    private void prepareData() {
        User randomUser = new User("Michal", "random@gmail.com", "qwerrt12345");

        randomUser.addActivity(new Activity(SportDisciplines.FOOTBALL, ActivityLevel.NEWBIE));
        randomUser.addActivity(new Activity(SportDisciplines.BOXING, ActivityLevel.INTERMEDIATE));
        randomUser.addActivity(new Activity(SportDisciplines.BASKETBALL, ActivityLevel.NEWBIE));

        User randomUser2 = new User("Dorota", "random2@gmail.com", "qwerrt12345");

        randomUser2.addActivity(new Activity(SportDisciplines.FOOTBALL, ActivityLevel.NEWBIE));
        randomUser2.addActivity(new Activity(SportDisciplines.BOXING, ActivityLevel.INTERMEDIATE));
        randomUser2.addActivity(new Activity(SportDisciplines.BASKETBALL, ActivityLevel.NEWBIE));

        usersMap.put(randomUser.getMailAddress(), randomUser);
        usersMap.put(randomUser2.getMailAddress(), randomUser2);

    }
}
