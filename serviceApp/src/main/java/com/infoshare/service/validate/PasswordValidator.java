package com.infoshare.service.validate;

import com.infoshare.service.domain.users.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.infoshare.service.utils.Tools.isPasswordsMatch;

public class PasswordValidator implements ConstraintValidator<Password, UserDTO> {

    public void initialize(Password constraint) {
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        return isPasswordsMatch(userDTO.getPassword(), userDTO.getRepeatPassword());
    }
}
