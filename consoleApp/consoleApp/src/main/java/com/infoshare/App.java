package com.infoshare;
import com.infoshare.activities.Activity;
import com.infoshare.activities.ActivityLevel;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.location.Address;
import com.infoshare.location.Town;
import com.infoshare.services.UserService;
import com.infoshare.users.User;
import com.infoshare.workoutPlaces.SportFacility;

import java.time.LocalTime;

public class App
{
    public static void main( String[] args )
    {

        User randomUser = new User("Michal","random@gmail.com","qwerrt12345");

        randomUser.addActivity(new Activity(SportDisciplines.FOOTBALL,ActivityLevel.NEWBIE));
        randomUser.addActivity(new Activity(SportDisciplines.BOXING,ActivityLevel.INTERMEDIATE));
        randomUser.addActivity(new Activity(SportDisciplines.BASKETBALL,ActivityLevel.NEWBIE));

        User randomUser2 = new User("Dorota","random2@gmail.com","qwerrt12345");

        randomUser2.addActivity(new Activity(SportDisciplines.FOOTBALL,ActivityLevel.NEWBIE));
        randomUser2.addActivity(new Activity(SportDisciplines.BOXING,ActivityLevel.INTERMEDIATE));
        randomUser2.addActivity(new Activity(SportDisciplines.BASKETBALL,ActivityLevel.NEWBIE));

        User randomUser3 = new User("Andrzej","random3@gmail.com","qwerrt12345");

        randomUser3.addActivity(new Activity(SportDisciplines.FOOTBALL,ActivityLevel.NEWBIE));
        randomUser3.addActivity(new Activity(SportDisciplines.BOXING,ActivityLevel.INTERMEDIATE));
        randomUser3.addActivity(new Activity(SportDisciplines.BASKETBALL,ActivityLevel.NEWBIE));

        User randomUser4 = new User("Beata","random4@gmail.com","qwerrt12345");

        randomUser4.addActivity(new Activity(SportDisciplines.FOOTBALL,ActivityLevel.NEWBIE));
        randomUser4.addActivity(new Activity(SportDisciplines.BOXING,ActivityLevel.INTERMEDIATE));
        randomUser4.addActivity(new Activity(SportDisciplines.BASKETBALL,ActivityLevel.NEWBIE));


        SportFacility facility1 = new SportFacility("COS Łódź",SportDisciplines.BOXING,"123 456 789",
                new Address(Town.GDAŃSK,"ul. Sportowa 1"),
                LocalTime.of(15,00), LocalTime.of(16,00), 50);

        UserService userService = new UserService();
        userService.addUser(randomUser);
        userService.addUser(randomUser2);
        userService.addUser(randomUser3);
        userService.addUser(randomUser4);

        userService.printUserList();


    }
}
