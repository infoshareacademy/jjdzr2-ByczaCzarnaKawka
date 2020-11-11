package com.infoshare.users;
import com.infoshare.location.Address;
import com.infoshare.tools.Tools;

public class UserService {
    public static User addNewUser(){
        String nickname= Tools.getFromUser("Podaj imię/nick:");
        String login= Tools.getFromUser("Podaj adres e-mail:");
        login=Tools.veryfityEmail(login);
        // TODO passwords are written by open text - fix it
        String password1= Tools.getFromUser("Podaj hasło:");
        String password2= Tools.getFromUser("Powtórz hasło:");
        String password= Tools.veryfityPassword(password1,password2);
        User user = new User(nickname, login, password);

        user.setAge(Tools.getIntFromUser("Ile masz lat:"));

        String phoneNumber=Tools.getFromUser("Podaj nr telefonu:");
        user.setPhoneNumber(Tools.veryfityPhoneNumber(phoneNumber));

        user.setSex(Tools.getSexFromUser("Podaj płeć: "));

        user.createActivityList();
        String next=new String();
        do {
            user.addActivity(Tools.getActivityFromUser());
            next=Tools.getFromUser("Chcesz dodoać kolejną dyscyplinę? Y/N ").toUpperCase();
        }while(next.equals("Y"));


        String choice = Tools.getFromUser("Chcesz podać adres zamieszkoania? Y?N").toUpperCase();
        if(choice.equals("Y")){
            user.setAddress(new Address(Tools.getTownFromUser("Podaj miasto"),Tools.getRoadFromUser()));
        }

        return user;
    }
}
