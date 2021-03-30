package com.infoshare.service.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static com.infoshare.service.utils.Tools.isMailUnique;

public class EmailExistValidator implements ConstraintValidator<EmailExist, String> {
@Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
    return isMailUnique(email);
    }
}
