package com.infoshare.menu;

import com.infoshare.services.FacilityService;
import com.infoshare.services.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final String MENU_HEADER = "*** GymBuddy Finder ***";
    private static final String[] MENU_OPTIONS = {
            "1. Stwórz nowego użytkownika.",
            "2. Zaloguj się - Funkcja tymczasowo niedostępna.",
            "3. Wyświetl użytkowników.",
            "4. Wyświetl obiekty do rezerwacji.",
            "5. Usuń użytkownika - Funkcja tymczasowo niedostępna.",
            "6. Usuń obiekt sportowy - Funkcja tymczasowo niedostępna.",
            "7. Wyszukaj użytkownika.",
            "8. Wyszukaj obiekt sporotwy - Funkcja tymczasowo niedostępna.",
            "0. Wyjdź z programu."
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
            System.out.println("Twój wybór:");
            try {
                userChoice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłowe dane.");
            }

            switch (userChoice) {
                case 1: {
                    System.out.println("Stwórz nowego użytkownika \n");
                    userService.handleNewUSer();
                    break;
                }
                case 2:
                case 5:
                case 6:
                case 8:{
                    System.out.println("Przepraszamy, funkcja tymczasowo niedostępna \n");
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
                case 7: {
                    userService.foundUser();
                    break;
                }
                case 0: {
                    System.out.println("Dzięki!!! Do zobaczenia!!!");
                    break;
                }
                default: {
                    System.out.println("Niepoprawny wybór. Wybierz ponownie! \n");
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


