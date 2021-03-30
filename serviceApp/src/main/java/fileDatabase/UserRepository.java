package fileDatabase;


import domain.users.User;
import utils.FileUtils;

import java.util.Map;
import java.util.stream.Collectors;


public class UserRepository {


    public Map<String, User> getUsersMap() {
        return FileUtils.readUsersJsonFile().stream()
                .collect(Collectors.toMap(User::getMailAddress, user -> user));
    }



}
