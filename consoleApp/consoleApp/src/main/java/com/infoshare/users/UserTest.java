package com.infoshare.users;

import com.infoshare.tools.Tools;

public class UserTest {
    public static void main(String[] args) {
       //User user= UserService.addNewUser();
       // System.out.println(Tools.veryfityEmail("mary1w.eqe.pl"));
       // System.out.println(Tools.veryfityPhoneNumber("123789"));
        User user=new User("mary","ma_ry","qqq");
        user.setSex(Tools.getSexFromUser("Podaj płeć z listy: "));
        System.out.println(user.getSex());

    }
}
