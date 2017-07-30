package com.change.changevest.web.ui;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserDTO> {
    @Override
    public void initialize(PasswordMatches passwordMatches) {

    }

    @Override
    public boolean isValid(UserDTO o, ConstraintValidatorContext constraintValidatorContext) {
        return o.getPassword().equals(o.getConfirmPassword());
    }
}
