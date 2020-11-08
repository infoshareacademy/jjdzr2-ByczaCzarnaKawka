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

    public User(String nickname, String login, String password) {
        this.nickname = nickname;
        this.mailAddress = login;
        this.password = password;

    }

    // checking method ... in progress
    public void printAllInfo(){
        System.out.println("nickname: " + nickname);
        System.out.println("password: " + password);
        System.out.println("age: " + age);
        System.out.println("phone number: " + phoneNumber);
        System.out.println("sex: " + sex);
        System.out.println("address: ");
        System.out.println(" town: " + address.getTownName());
        System.out.println(" road: " + address.getLocalRoad().toString());
        System.out.println("-----------------------------------------");

        System.out.println("My Activities: \n");
        for (Activity element: activityList) {
            element.printActivities();
            System.out.println("-------------------------");
        }
    }

    public void createActivityList(){
        activityList = new ArrayList<>();
    }

    public void addActivity(Activity activity){

        activityList.add(activity);
    }

    public String getNickname() {
        return nickname;
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
