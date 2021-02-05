package validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)

public @interface EmailExist {

    String message() default "e-mail address already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
