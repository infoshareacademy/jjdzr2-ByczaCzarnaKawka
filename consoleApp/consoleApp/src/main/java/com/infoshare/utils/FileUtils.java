package com.infoshare.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.users.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String USERS_JSON_FILE = "./consoleApp/consoleApp/src/main/resources/Users.json";
    public static void saveUsersToJsonFile(List<User> users) {
        try (Writer writer = new FileWriter(USERS_JSON_FILE)) {
            GSON.toJson(users, writer);
            System.out.println("Users saved to json file:  " + USERS_JSON_FILE);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static List<User> readUsersJsonFile() {
        try (Reader reader = new FileReader(USERS_JSON_FILE)) {
            // System.out.println("Reading Users from json file: " + USERS_JSON_FILE);
            Type listType = new TypeToken<ArrayList<User>>(){}.getType();
            List<User> users = GSON.fromJson(reader, listType);
            // System.out.println("Users successfully uploaded. Number of users: " + users.size());
            return users;
        } catch (IOException e) {
            System.out.println("Users json file not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}