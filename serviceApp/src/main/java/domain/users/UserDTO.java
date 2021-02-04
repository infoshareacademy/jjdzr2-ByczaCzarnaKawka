package domain.users;

import domain.activities.Activity;
import domain.activities.ActivityLevel;
import domain.activities.SportDisciplines;
import domain.location.Address;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;


public class UserDTO {
    @NotEmpty(message = "nickname can't be empty")
    private String nickname;
    @NotEmpty(message = "e-mail can't be empty")
    private String mailAddress;
    @NotEmpty(message = "password can't be empty")
    private String password;
    @NotEmpty(message = "password can't be empty")
    private String repeatPassword;
    @Min(1)
    @Max(130)
    private int age;
    @NotEmpty(message = "phone number can't be empty")
    private String phoneNumber;
    private Gender gender;
    private Address address;
    //@NotEmpty(message = "activity can't be empty")
    //private List<Activity> activityList;
    private SportDisciplines sportDisciplines;
    private ActivityLevel activityLevel;


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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //    public List<Activity> getActivityList() {
//        return activityList;
//    }
//
//    public void setActivityList(List<Activity> activityList) {
//        this.activityList = activityList;
//    }

    public SportDisciplines getSportDisciplines() {
        return sportDisciplines;
    }

    public void setSportDisciplines(SportDisciplines sportDisciplines) {
        this.sportDisciplines = sportDisciplines;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
