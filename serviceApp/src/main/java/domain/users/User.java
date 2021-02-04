package domain.users;

import domain.activities.Activity;
import domain.location.Address;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String nickname;
    private String mailAddress;
    private String password;
    private int age;
    private String phoneNumber;
    private Gender gender;
    private Address address;
    private List<Activity> activityList;

    public User(String nickname, String mailAddress, String password, int age, String phoneNumber, Gender gender, Address address, List<Activity> activityList) {
        this.nickname = nickname;
        this.mailAddress = mailAddress;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.activityList = activityList;
    }

    public User(String nickname, String mailAddress, String password) {
        this.nickname = nickname;
        this.mailAddress = mailAddress;
        this.password = password;
        this.age = 0;
        this.phoneNumber = "";
        this.gender = null;
        this.address = new Address(null, " ");
        this.activityList = new ArrayList<>();
    }

    public void printBasicInfo() {
        System.out.println("Nickname: " + getNickname());
        System.out.println("E-mail: " + getMailAddress());
        System.out.println("Address: " + getAddress().getTownName() + ", " + getAddress().getStreetName());
        System.out.println("Activities:");
        for (Activity element : activityList) {
            System.out.println("Sport: " + element.getSportDisciplines());
            System.out.println("Experience level: " + element.getActivityLevel());
            System.out.println("----------------");
        }
    }

    public void addActivity(Activity activity) {

        activityList.add(activity);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getSex() {
        return gender;
    }

    public void setSex(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    @Override
    public String toString() {
        return "User{ \n" +
                "nickname='" + nickname + '\'' +
                "," + "\n" + "mailAddress='" + mailAddress + '\'' +
                "," + "\n" + "password='" + password + '\'' +
                "," + "\n" + "age=" + age +
                "," + "\n" + "phoneNumber='" + phoneNumber + '\'' +
                "," + "\n" + "sex=" + gender +
                "," + "\n \n" + "address=" + address +
                "," + "\n \n" + "activityList=" + activityList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nickname, user.nickname) &&
                Objects.equals(mailAddress, user.mailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, mailAddress);
    }


}
