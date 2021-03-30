package com.infoshare.service.domain.users;

import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Address;
import com.infoshare.service.validate.BornYear;
import com.infoshare.service.validate.EmailExist;
import com.infoshare.service.validate.Password;

import javax.validation.constraints.*;


@Password
public class UserDTO {
    @NotBlank(message = "nickname can't be empty")
    @Size(min = 1, max = 16, message = "nickname must be between 1 and 16 characters")
    private String nickname;

    @NotEmpty(message = "e-mail can't be empty")
    @Pattern(regexp = "[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,4}", message = "e-mail address seems to be incorrect")
    @EmailExist
    private String mailAddress;

    @NotBlank(message = "password can't be empty")
    @Size(min = 8, message = "password should have min 8 characters long")
    private String password;

    private String repeatPassword;
    @BornYear
    private int bornYear;

    @NotEmpty(message = "phone number can't be empty")
    @Pattern(regexp = "\\d\\d\\d\\d\\d\\d\\d\\d\\d", message = "phone number seems to be incorrect")
    private String phoneNumber;

    private Gender gender;
    private Address address;
    private SportDiscipline sportDiscipline;
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

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
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

    public SportDiscipline getSportDiscipline() {
        return sportDiscipline;
    }

    public void setSportDiscipline(final SportDiscipline sportDiscipline) {
        this.sportDiscipline = sportDiscipline;
    }

    public ActivityLevel getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(final ActivityLevel activityLevel) {
        this.activityLevel = activityLevel;
    }
}
