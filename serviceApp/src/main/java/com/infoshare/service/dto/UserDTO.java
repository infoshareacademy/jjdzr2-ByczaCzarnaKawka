package com.infoshare.service.dto;

import com.infoshare.service.domain.activities.ActivityLevel;
import com.infoshare.service.domain.activities.SportDiscipline;
import com.infoshare.service.domain.location.Address;
import com.infoshare.service.domain.users.Gender;
import com.infoshare.service.validate.BornYear;
import com.infoshare.service.validate.EmailExist;
import com.infoshare.service.validate.Password;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Password
public class UserDTO {

    private UUID id;

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

}
