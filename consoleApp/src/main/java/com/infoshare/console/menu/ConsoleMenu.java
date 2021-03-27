package com.infoshare.console.menu;

import com.infoshare.service.service.console.FacilityConsoleService;
import com.infoshare.service.service.console.UserConsoleService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleMenu {

    private static final String MENU_HEADER = "*** GymBuddy Finder ***";
    private static final String[] MENU_OPTIONS = {
            "1. Create new user.",
            "2. Log in - Function is temporary unavailable.",
            "3. Show users list.",
            "4. Show facilities to book.",
            "5. Delete user - Function is temporary unavailable.",
            "6. Delete sport facility - Function is temporary unavailable.",
            "7. Find user.",
            "8. Find sport facility - Function is temporary unavailable.",
            "0. Exit."
    };

    private UserConsoleService userConsoleService;
    private FacilityConsoleService facilityConsoleService;

    public ConsoleMenu() {
        this.userConsoleService = new UserConsoleService();
        this.facilityConsoleService = new FacilityConsoleService();
    }

    public void start() {
        System.out.println(MENU_HEADER);
        handleUserChoice();
    }

    private void handleUserChoice() {
        int userChoice = 1;
        do {
            showMenu();

            //FIXME: METODA PRIVATE
            System.out.println("Your choice:");
            try {
                userChoice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Give correct data.");
            }

            switch (userChoice) {
                case 1: {

                    userConsoleService.handleNewUSer();
                    break;
                }
                case 3: {
                    userConsoleService.printUserList();
                    break;
                }
                case 4: {
                    facilityConsoleService.printFacilityList();
                    break;
                }

                case 2:
                case 5:
                case 6:
                case 8: {
                    System.out.println("Sorry, Function is temporary unavailable! \n");
                    break;
                }
                case 7: {
                    userConsoleService.foundUser();
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


