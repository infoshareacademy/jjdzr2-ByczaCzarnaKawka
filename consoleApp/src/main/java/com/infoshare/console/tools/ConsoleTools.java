package com.infoshare.console.tools;

import com.infoshare.service.domain.activities.Activity;
import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Address;

import com.infoshare.service.domain.location.Town;

import com.infoshare.console.services.UserConsoleService;
import com.infoshare.service.domain.users.Gender;
import com.infoshare.service.domain.users.User;
import com.infoshare.service.utils.FileUtils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleTools {
    public static String getFromUser(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.next();
    }

    public static int getIntFromUser(String message) {
        int temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        try {
            temp = scanner.nextInt();
        } catch (InputMismatchException e) {
            return getIntFromUser(" You didn't provide a number. Please provide the value again: ");
        }
        return temp;
    }

    public static String getPasswordFromUser() {

        String password1 = ConsoleTools.getFromUser("Enter password: ");
        String password2 = ConsoleTools.getFromUser("Confirm password: ");
        return verificationPassword(password1, password2);
    }

    public static String verificationPassword(String password1, String password2) {
        do {
            if (password1.equals(password2))
                return password1;
            else {

                System.out.println("Passwords do not match. ");
                password1 = getFromUser("Enter password: ");
                password2 = getFromUser("Confirm password: ");
            }
        } while (!password1.equals(password2));
        return password1;
    }

    public static String getLoginFromUser() {
        String login = ConsoleTools.getFromUser("Enter e-mail address: ");
        return verifyEmail(login);
    }

    public static boolean isMailUnique(String email) {
        List<User> allUsers = FileUtils.readUsersJsonFile();
        boolean isUnique = true;
        for (int i = 0; i < allUsers.size(); i++) {
            boolean isUniqueTemp = !email.equalsIgnoreCase(allUsers.get(i).getMailAddress());
            if (!isUniqueTemp) {
                System.out.println("This e-mail address already exists!");
                isUnique = false;
            }
        }
        return isUnique;
    }

    public static String verifyEmail(String email) {
        boolean isUniq = isMailUnique(email);
        while (!isUniq) {
            email = getFromUser("Enter new e-mail, this e-mail address is already taken!");
            isUniq = isMailUnique(email);
        }
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}");
        Matcher matcher;
        do {
            matcher = pattern.matcher(email);
            if (!matcher.find()) {
                email = getFromUser("E-mail address seems to be incorrect. Enter correct e-mail: ");
                matcher = pattern.matcher(email);
            }
            matcher = pattern.matcher(email);
        } while (!matcher.find());
        return email;
    }


    public static int getAgeFromUser(){
        int age=getIntFromUser("Enter your age: ");
        if(age<=0 || age>130){
            System.out.println("Enter your real age (1-130): ");
            return getAgeFromUser();
        }
        return age;
    }

    public static String getPhoneNumberFromUser() {

        String phoneNumber = getFromUser("Enter your phone number: ");
        return verifyPhoneNumber(phoneNumber);
    }

    public static String verifyPhoneNumber(String phoneNumber) {
        //make regular expression (wyrazenie regularne) for validate phone number
        Pattern pattern = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        Matcher matcher;
        do {
            matcher = pattern.matcher(phoneNumber);
            if (!matcher.find()) {
                phoneNumber = getFromUser("Phone number seems to be incorrect. Enter phone number: ");
                matcher = pattern.matcher(phoneNumber);
            }
            matcher = pattern.matcher(phoneNumber);
        } while (!matcher.find());
        return phoneNumber;
    }


    public static Gender getGenderFromUser(String message) {
        Gender.printValues();
        String gender = getFromUser(message);
        return UserConsoleService.valueOfGenderLabel(gender);
    }

    public static Town getTownFromUser(String message) {
        Town.printValue();
        String town = getFromUser(message);
        return UserConsoleService.valueOfTownLabel(town);
    }

    public static String getStreetFromUser() {
        String road = getFromUser("Enter street name: ");
        String number = getFromUser("Enter house number: ");
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher matcher;
        do {
            matcher = numberPattern.matcher(number);
            if (!matcher.find()) {
                number = getFromUser("Number seems to be incorrect. Please enter correct number: ");
                matcher = numberPattern.matcher(number);
            }
            matcher = numberPattern.matcher(number);
        } while (!matcher.find());
        return road + number;
    }

    public static Address getAddressFromUser() {
        String choice = ConsoleTools.getFromUser("Would you like to provide your address? Y/N ").toUpperCase();
        Address address = new Address();
        if ("Y".equals(choice)) {
            Town town = ConsoleTools.getTownFromUser("Enter town name: ");
            String street = ConsoleTools.getStreetFromUser();
            address = new Address(town, street);
        }
        return address;
    }

    public static ActivityLevel getActivityLevelFromUser(String message) {
        ActivityLevel.printValues();
        String level = getFromUser(message);
        return UserConsoleService.valueOfActivityLabel(level);
    }

    public static SportDiscipline getSportDisciplinesFromUser(String message) {
        SportDiscipline.printValues();
        String discipline = getFromUser(message);
        return UserConsoleService.valueOfSportDisciplinesLabel(discipline);
    }

    public static User getActivityFromUser(User user) {
        String choice;
        Activity activity;
        SportDiscipline discipline;
        ActivityLevel level;
        do {
            discipline = getSportDisciplinesFromUser("Wybierz dyscypline: ");
            level = getActivityLevelFromUser("Wybierz poziom zaawansowania: ");
            activity = new Activity(discipline, level);
            user.addActivity(activity);
            choice = ConsoleTools.getFromUser("Chcesz dodoać kolejną dyscyplinę? Y/N ").toUpperCase();
        } while ("Y".equals(choice));
        return user;
    }
}

