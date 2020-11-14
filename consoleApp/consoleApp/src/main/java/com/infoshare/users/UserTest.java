package com.infoshare.users;


public class UserTest {
    public static void main(String[] args) {

        User user = UserService.addNewUser();
        user.printBasicInfo();
    }
}
