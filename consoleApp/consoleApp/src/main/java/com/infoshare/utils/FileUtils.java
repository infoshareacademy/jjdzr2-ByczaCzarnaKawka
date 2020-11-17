package com.infoshare.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.users.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    //"./consoleApp/consoleApp/src/main/resources/Users.json"
    private static final String USERS_JSON_FILE = "./src/main/resources/Users.json";
    public static void saveUsersToJsonFile(User users) {
        try (Writer writer = new FileWriter(USERS_JSON_FILE)) {
            GSON.toJson(users, writer);
            System.out.println("Users saved to json file:  " + USERS_JSON_FILE);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

//    public static User readUsersJsonFile() {
//        try (Reader reader = new FileReader(USERS_JSON_FILE)) {
//            System.out.println("Reading Users from json file: " + USERS_JSON_FILE);
//            User users = GSON.fromJson(reader, User.class);
//            System.out.println("Users successfully uploaded. Number of users: " + users.getUsers().size());
//            return users;
//        } catch (IOException e) {
//            System.out.println("Users json file not found or broken: " + e.getMessage());
//            return new User();
//        }
//    }
}