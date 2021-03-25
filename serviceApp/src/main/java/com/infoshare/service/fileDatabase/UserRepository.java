package com.infoshare.service.fileDatabase;


import com.infoshare.service.domain.users.User;
import com.infoshare.service.utils.FileUtils;

import java.util.Map;
import java.util.stream.Collectors;


public class UserRepository {


    public Map<String, User> getUsersMap() {
        return FileUtils.readUsersJsonFile().stream()
                .collect(Collectors.toMap(User::getMailAddress, user -> user));
    }

}
