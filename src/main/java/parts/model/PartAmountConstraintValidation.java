package parts.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PartAmountConstraintValidation implements ConstraintValidator<PartAmountConstraint, String> {
    @Override
    public void initialize(PartAmountConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value!=null && value.matches("[0-9]+");
    }
}
