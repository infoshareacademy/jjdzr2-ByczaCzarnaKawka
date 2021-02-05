package utils;

import domain.users.User;

import java.util.List;

public class Tools {
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
}
