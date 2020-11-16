package com.infoshare.reservations;

import com.infoshare.users.User;
import com.infoshare.workoutPlaces.SportFacility;

import java.util.Objects;

public class Reservation {

    private User user;
    private SportFacility sportFacility;


    public Reservation(User user, SportFacility sportFacility) {
        this.user = user;
        this.sportFacility = sportFacility;
    }

    public void returnReservationInfo() {
        System.out.println("User name: " + user.getNickname());
        System.out.println("Contact number: " + user.getPhoneNumber() + "\n");
        System.out.println(sportFacility.toString());
    }

    public SportFacility getSportFacility() {
        return sportFacility;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Reservation{ \n" +
                "sportFacility=" + sportFacility +
                "," + "\n" + "user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(sportFacility, that.sportFacility) &&
                Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sportFacility, user);
    }
}
