package com.infoshare.users;
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


        //TODO sex - enum - how can i work with it



        //TODO Address - class - includes enum Town!!!

        //TODO actyvityList - list - how can i work with it


        //TODO add users to json file by Łukasz's feature

        return user;
    }
}
