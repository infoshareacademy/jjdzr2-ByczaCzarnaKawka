import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final String MENU_HEADER = "GymBuddy Finder";
    private static final String [] MENU_OPTIONS = {
            "1. Stwórz nowego użytkownika",
            "2. Zaloguj się",
            "0. Wyjdź z programu"
    };


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
            }
            catch (InputMismatchException e) {
                System.out.println("Podaj prawidłowe dane.");
            }

            switch (userChoice) {
                case 1: {
                    System.out.println("Stwórz nowego użytkownika");
                    break;
                }
                case 2: {
                    System.out.println("Zaloguj się");
                    break;
                }
                case 0: {
                    System.out.println("Wyjdź z programu");
                    break;
                }
                default: {
                    System.out.println("Zły wybór");
                }

            }
        }while (userChoice !=0);
    }

    public void showMenu() {
        for(String menuOption : MENU_OPTIONS){
            System.out.println(menuOption);
        }
    }
}


