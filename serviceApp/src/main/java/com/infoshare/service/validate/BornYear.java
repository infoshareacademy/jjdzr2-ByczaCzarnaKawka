package com.infoshare.service.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target(FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BornYearValidator.class)

public @interface BornYear {

    String message() default "you may be 16 or older";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
