package com.infoshare.users;
import com.infoshare.activities.Activity;
import com.infoshare.location.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {

    private String nickname;
    private String mailAddress;
    private String password;
    private int age;
    private String phoneNumber;
    private Sex sex;
    private Address address;
    private List<Activity> activityList;

    public User(String nickname, String mailAddress, String password) {
        this.nickname = nickname;
        this.mailAddress = mailAddress;
        this.password = password;
        this.age = 0;
        this.phoneNumber = "";
        this.sex = null;
        this.address = new Address(null," ");
        this.activityList = new ArrayList<>();
    }

    public void printBasicInfo(){
        System.out.println("Nickname: " + getNickname());
        System.out.println("E-mail: " + getMailAddress());
        System.out.println("Address: " + getAddress().getTownName() + ", " + getAddress().getRoadName());

        System.out.println("Activities:");
            for (Activity element : activityList) {
            System.out.println("Sport: " + element.getSportDisciplines());
            System.out.println("Experience level: " + element.getActivityLevel());
            System.out.println("----------------");
        }
    }

    public void addActivity(Activity activity){

        activityList.add(activity);
    }

    public String getNickname() {
        return nickname;
    }

    public String getMailAddress() {
        return mailAddress;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {

        this.sex = sex;
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


    @Override
    public String toString() {
        return "User{ \n" +
                "nickname='" + nickname + '\'' +
                "," + "\n" + "mailAddress='" + mailAddress + '\'' +
                "," + "\n" + "password='" + password + '\'' +
                "," + "\n" + "age=" + age +
                "," + "\n" + "phoneNumber='" + phoneNumber + '\'' +
                "," + "\n" + "sex=" + sex +
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
