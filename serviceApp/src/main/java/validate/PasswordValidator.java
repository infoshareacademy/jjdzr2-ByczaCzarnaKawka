package validate;

import domain.users.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    public void initialize(Password constraint) {
    }

    public boolean isValid(String password, ConstraintValidatorContext context) {

        return false;
    }
}
