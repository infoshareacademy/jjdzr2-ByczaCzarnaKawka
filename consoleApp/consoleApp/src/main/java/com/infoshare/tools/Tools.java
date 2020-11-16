package com.infoshare.tools;

import com.infoshare.activities.Activity;
import com.infoshare.activities.ActivityLevel;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.location.Address;
import com.infoshare.location.Town;
import com.infoshare.users.Sex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {
    public static String getFromUser(String message) {
        String temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return temp = scanner.next();
    }

    public static int getIntFromUser(String message) {
        int temp;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return temp = scanner.nextInt();
    }

    public static String getPasswordFromUser() {
        String password1 = Tools.getFromUser("Podaj hasło:");
        String password2 = Tools.getFromUser("Powtórz hasło:");
        return verificatePasswprd(password1, password2);
    }

    public static String verificatePasswprd(String password1, String password2) {
        do {
            if (password1.equals(password2))
                return password1;
            else {
                System.out.println("Hasła nie są identyczne.");
                password1 = getFromUser("Podaj hasło:");
                password2 = getFromUser("Powtórz hasło:");
            }
        } while (!password1.equals(password2));
        return password1;
    }

    public static String getLoginFromUser() {
        String login = Tools.getFromUser("Podaj adres e-mail:");
        return veryfityEmail(login);
    }

    public static String veryfityEmail(String email) {

        //make regular expression (wyrazenie regularne) for validate e-mail
        Pattern pattern = Pattern.compile(".+@.+\\..+");
        Matcher matcher;
        do {
            matcher = pattern.matcher(email);
            if (!matcher.find()) {
                email = getFromUser("E-mail wydaje się być nieprawidłowy. Podaj e-mail");
                matcher = pattern.matcher(email);
            }
            matcher = pattern.matcher(email);
        } while (!matcher.find());
        return email;
    }

    public static String getPhoneNumberFromUser() {
        String phonNumber = getFromUser("Podaj nr telefonu:");
        return veryfityPhoneNumber(phonNumber);
    }

    public static String veryfityPhoneNumber(String phoneNumber) {
        //make regular expression (wyrazenie regularne) for validate phone number
        Pattern pattern = Pattern.compile("\\d\\d\\d\\d\\d\\d\\d\\d\\d");
        Matcher matcher;
        do {
            matcher = pattern.matcher(phoneNumber);
            if (!matcher.find()) {
                phoneNumber = getFromUser("Numer telefonu wydaje się być nieprawidłowy. Podaj numer telefonu");
                matcher = pattern.matcher(phoneNumber);
            }
            matcher = pattern.matcher(phoneNumber);
        } while (!matcher.find());
        return phoneNumber;
    }

    public static Sex getSexFromUser(String message) {
        Sex.printValues();
        String sex = getFromUser(message);
        return Sex.valueOfLabel(sex);
    }

    public static Town getTownFromUser(String message) {
        Town.printValiu();
        String town = getFromUser(message);
        return Town.valueOfLabel(town);
    }

    public static String getRoadFromUser() {
        String road = getFromUser("Podaj nazwę ulicy: ");
        String number = getFromUser("Podaj numer ulicy: ");
        return road + number;
    }

    public static Address getAddressFromUser() {
        String choice = Tools.getFromUser("Chcesz podać adres zamieszkoania? Y/N").toUpperCase();
        Address address = new Address(null, null);
        if ("Y".equals(choice)) {
            Town town = Tools.getTownFromUser("Podaj miasto");
            String road = Tools.getRoadFromUser();
            address = new Address(town, road);
            return address;
        }
        return address;
    }

    public static ActivityLevel getActivityLevelFromUser(String message) {
        ActivityLevel.printValues();
        String level = getFromUser(message);
        return ActivityLevel.valueOfLabel(level);
    }

    public static SportDisciplines getSportDisciplinesFromUser(String message) {
        SportDisciplines.printValues();
        String discipline = getFromUser(message);
        return SportDisciplines.valueOfLabel(discipline);
    }

    public static Activity getActivityFromUser() {

        SportDisciplines discipline;
        ActivityLevel level;
        discipline = getSportDisciplinesFromUser("Wybierz dyscypline: ");
        level = getActivityLevelFromUser("Wybierz poziom zaawansowania: ");
        Activity activity = new Activity(discipline, level);
        return activity;

    }
}

