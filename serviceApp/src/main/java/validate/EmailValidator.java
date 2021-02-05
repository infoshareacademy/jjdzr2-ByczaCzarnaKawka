package validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static utils.Tools.isMailUnique;

public class EmailValidator implements ConstraintValidator<EmailExist, String> {
    public void initialize(EmailExist constraint) {
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {

       return isMailUnique(email);

    }
}
