package com.change.changevest.web.ui;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
    String message() default "Password must be a minimum of 8 characters, with at least one upper-case alphabetical, one " +
            "lower-case alphabetical and one number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
