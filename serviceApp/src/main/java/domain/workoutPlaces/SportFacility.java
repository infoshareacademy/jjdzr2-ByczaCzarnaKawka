package domain.workoutPlaces;

import domain.activities.SportDisciplines;
import domain.location.Address;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Objects;

public class SportFacility {

    private static Integer classCounter = 0;
    private Integer ordinalNumber;

    private String name;
    private SportDisciplines discipline;

    private String phoneNumber;
    private Address address;

    private LocalTime openHour;
    private LocalTime closeHour;

    private BigDecimal price;

    public SportFacility(String facilityName, SportDisciplines sportDiscipline, String phoneNumber, Address address, LocalTime startHour, LocalTime endHour, BigDecimal price) {
        this.name = facilityName;
        this.discipline = sportDiscipline;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.openHour = startHour;
        this.closeHour = endHour;
        this.price = price;
        this.ordinalNumber = 1 + classCounter;
        classCounter++;
    }

    public void printBasicInfo() {
        System.out.println("Ordinal number: " + getOrdinalNumber());
        System.out.println("Name: " + getName());
        System.out.println("Discipline: " + getDiscipline());
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println(getAddress());
        System.out.println("Open hour: " + getOpenHour());
        System.out.println("Close hour: " + getCloseHour());
        System.out.println("Price per hour: " + getPrice().toString() + "zł");

    }

    public String getName() {
        return name;
    }

    public SportDisciplines getDiscipline() {
        return discipline;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public LocalTime getOpenHour() {
        return openHour;
    }

    public LocalTime getCloseHour() {
        return closeHour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getOrdinalNumber() {
        return ordinalNumber;
    }

    @Override
    public String toString() {
        return "SportFacility: no." + getOrdinalNumber() + "{ \n" +
                "facilityName='" + name + '\'' +
                "," + "\n" + "sportDiscipline=" + discipline +
                "," + "\n" + "phoneNumber='" + phoneNumber + '\'' +
                "," + "\n" + "address=" + address +
                "," + "\n" + "startHour=" + openHour +
                "," + "\n" + "endHour=" + closeHour +
                "," + "\n" + "price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportFacility facility = (SportFacility) o;
        return Objects.equals(name, facility.name) &&
                discipline == facility.discipline &&
                Objects.equals(phoneNumber, facility.phoneNumber) &&
                Objects.equals(address, facility.address) &&
                Objects.equals(openHour, facility.openHour) &&
                Objects.equals(closeHour, facility.closeHour) &&
                Objects.equals(price, facility.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, discipline, phoneNumber, address, openHour, closeHour, price);
    }
}


