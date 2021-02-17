package no.bouvet.customvalidationexample.validations.fnr;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FnrValidation implements
        ConstraintValidator<FnrConstraint, String> {

    @Override
    public void initialize(FnrConstraint fnr) {
    }

    @Override
    public boolean isValid(String fnr,
                           ConstraintValidatorContext cxt) {
        return fnr != null && fnr.matches("^[0-9]+$")
                && fnr.length() == 11;
    }

}
