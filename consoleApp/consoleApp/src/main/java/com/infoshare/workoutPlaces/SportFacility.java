package com.infoshare.workoutPlaces;
import com.infoshare.activities.SportDisciplines;
import com.infoshare.location.Address;
import java.time.LocalTime;
import java.util.Objects;

public class SportFacility {

    private String facilityName;
    private SportDisciplines sportDiscipline;

    private String phoneNumber;
    private Address address;

    private LocalTime startHour;
    private LocalTime endHour;

    private double price;

    private boolean isItBooked;

    public SportFacility(String facilityName, SportDisciplines sportDiscipline, String phoneNumber, Address address, LocalTime startHour, LocalTime endHour, double price) {
        this.facilityName = facilityName;
        this.sportDiscipline = sportDiscipline;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.startHour = startHour;
        this.endHour = endHour;
        this.price = price;
        isItBooked = false;
    }

    public double returnCostPerPerson (int numberOfPlayers){
        return price/numberOfPlayers;
    }

    public void bookAFacility(){
        if(isItBooked){
            System.out.println("Unfortunately the place is already booked!");
        }else{
            isItBooked = true;
            System.out.println("Congratulation! You've booked a workout place!");
        }
    }

    public void cancelABooking(){
        isItBooked = false;
        System.out.println("The place is available!");
    }

    public String getFacilityName() {
        return facilityName;
    }

    public SportDisciplines getSportDiscipline() {
        return sportDiscipline;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public double getPrice() {
        return price;
    }

    public boolean isItBooked() {
        return isItBooked;
    }

    @Override
    public String toString() {
        return "SportFacility{ \n" +
                "facilityName='" + facilityName + '\'' +
                "," + "\n" + "sportDiscipline=" + sportDiscipline +
                "," + "\n" + "phoneNumber='" + phoneNumber + '\'' +
                "," + "\n" + "address=" + address +
                "," + "\n" + "startHour=" + startHour +
                "," + "\n" + "endHour=" + endHour +
                "," + "\n" + "price=" + price +
                "," + "\n" + "isItBooked=" + isItBooked +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportFacility that = (SportFacility) o;
        return Objects.equals(facilityName, that.facilityName) &&
                sportDiscipline == that.sportDiscipline &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(address, that.address) &&
                Objects.equals(startHour, that.startHour) &&
                Objects.equals(endHour, that.endHour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(facilityName, sportDiscipline, phoneNumber, address, startHour, endHour);
    }
}
