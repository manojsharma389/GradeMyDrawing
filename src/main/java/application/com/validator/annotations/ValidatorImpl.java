package application.com.validator.annotations;

import application.com.model.ClassRegistryModel;
import application.com.validator.Validatable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidatorImpl implements ConstraintValidator<Validate, Validatable> {

    @Override
    public void initialize(Validate validator) {

    }

    @Override
    public boolean isValid(Validatable validatable, ConstraintValidatorContext constraintValidatorContext) {
        return validatable.isValid();
    }
}
