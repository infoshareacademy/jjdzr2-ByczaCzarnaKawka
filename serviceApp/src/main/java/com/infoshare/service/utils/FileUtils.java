package com.infoshare.service.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.service.domain.users.User;
import com.infoshare.service.domain.workoutPlace.SportFacility;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String USERS_JSON_FILE = "./consoleApp/src/main/resources/Users.json";
    private static final String SPORTS_JSON_FILE = "./consoleApp/src/main/resources/SportsFacilities.json";

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

            Type listType = new TypeToken<ArrayList<User>>() {
            }.getType();
            List<User> users = GSON.fromJson(reader, listType);
            return users;
        } catch (IOException e) {
            System.out.println("Users json file not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public static List<SportFacility> readSportsFacilities() {
        try (Reader reader = new FileReader(SPORTS_JSON_FILE)) {
            Type listType = new TypeToken<ArrayList<SportFacility>>() {
            }.getType();
            List<SportFacility> sportFacilityList = GSON.fromJson(reader, listType);
            return sportFacilityList;

        } catch (IOException e) {
            System.out.println("Sport Facilities json file not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}