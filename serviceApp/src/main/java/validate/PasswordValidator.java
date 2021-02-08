package validate;

import domain.users.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static utils.Tools.isPasswordsMatch;

public class PasswordValidator implements ConstraintValidator<Password, UserDTO> {

    public void initialize(Password constraint) {
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        return isPasswordsMatch(userDTO.getPassword(), userDTO.getRepeatPassword());
    }
}
