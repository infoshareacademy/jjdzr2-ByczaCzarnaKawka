package validate;

import domain.users.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static utils.Tools.isMailUnique;

public class EmailExistValidator implements ConstraintValidator<EmailExist, String> {
@Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return isMailUnique(email);
    }
}
