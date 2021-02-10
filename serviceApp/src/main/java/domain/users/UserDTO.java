package domain.users;

import domain.activities.ActivityLevel;
import domain.activities.SportDisciplines;
import domain.location.Address;
import validate.BornYear;
import validate.EmailExist;
import validate.Password;

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
