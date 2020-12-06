package com.infoshare.menu;

import com.infoshare.services.FacilityService;
import com.infoshare.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final String MENU_HEADER = "*** GymBuddy Finder ***";
    private static final String[] MENU_OPTIONS = {
            "1. Create new user.",
            "2. Log in - Function is temporary unavailable.",
            "3. Show users list.",
            "4. Show facilities to book.",
            "5. Delete user - Function is temporary unavailable.",
            "6. Delete sport facility - Function is temporary unavailable.",
            "7. Find user - Function is temporary unavailable.",
            "8. Find sport facility - Function is temporary unavailable.",
            "0. Exit."
    };

    private UserService userService;
    private FacilityService facilityService;

    public Menu() {
        this.userService = new UserService();
        this.facilityService = new FacilityService();
    }

    public void start() {
        System.out.println(MENU_HEADER);
        handleUserChoice();
    }

    private void handleUserChoice() {
        int userChoice = 1;
        do {
            showMenu();
            System.out.println("Your choice:");
            try {
                userChoice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Give correct data.");
            }

            switch (userChoice) {
                case 1: {
                    System.out.println("Create a new user.\n");
                    userService.handleNewUSer();
                    break;
                }
                case 3: {
                    userService.printUserList();
                    break;
                }
                case 4: {
                    facilityService.printFacilityList();
                    break;
                }
                case 2:
                case 5:
                case 6:
                case 7:
                case 8: {
                    System.out.println("Sorry, Function is temporary unavailable! \n");
                    break;
                }
                case 0: {
                    System.out.println("Thanks! See you!!!");
                    break;
                }
                default: {
                    System.out.println("Wrong choice. Try again! \n");
                }

            }
        } while (userChoice != 0);
    }

    public void showMenu() {
        for (String menuOption : MENU_OPTIONS) {
            System.out.println(menuOption);
        }
    }
}


