package com.infoshare;

import com.infoshare.menu.Menu;
import com.infoshare.users.User;
import com.infoshare.utils.FileUtils;

public class App {
    public static void main(String[] args) {
        new Menu().start();
        //User user = FileUtils.readUsersJsonFile();


    }
}
