package com.infoshare.dao;

import com.infoshare.users.User;

import com.infoshare.utils.FileUtils;

import java.util.Map;
import java.util.stream.Collectors;


public class UserRepository {

    private Map<String, User> usersMap;

    public UserRepository() {

        this.usersMap = getUsersMap();
    }

    public Map<String, User> getUsersMap() {
        return  FileUtils.readUsersJsonFile().stream().collect(Collectors.toMap(User::getMailAddress, user -> user));

    }

}
