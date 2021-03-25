package com.infoshare.service.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailExistValidator.class)

public @interface EmailExist {

    String message() default "e-mail address already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
