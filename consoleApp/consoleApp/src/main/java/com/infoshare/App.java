package com.infoshare;


import com.infoshare.activities.Activity;
import com.infoshare.activities.ActivityLevel;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.location.Address;
import com.infoshare.location.LocalRoad;
import com.infoshare.location.Town;
import com.infoshare.users.Sex;
import com.infoshare.users.User;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello Bycza Czarna Kawka" );

        User randomUser = new User("MichalM","random@gmail.com","qwerrt12345");

        randomUser.setAddress(new Address(Town.Gdańsk,new LocalRoad("random road", "8")));
        randomUser.setAge(28);
        randomUser.setPhoneNumber("+48  123 456 789");
        randomUser.setSex(Sex.male);

        randomUser.createActivityList();
        randomUser.addActivity(new Activity(SportDisciplines.Football,ActivityLevel.Newbie));
        randomUser.addActivity(new Activity(SportDisciplines.Boxing,ActivityLevel.Intermediate));
        randomUser.addActivity(new Activity(SportDisciplines.Basketball,ActivityLevel.Newbie));

        randomUser.printAllInfo();


    }
}
