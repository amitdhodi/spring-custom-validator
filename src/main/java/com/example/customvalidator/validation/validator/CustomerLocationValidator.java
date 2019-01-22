package com.example.customvalidator.validation.validator;

import com.example.customvalidator.api.models.CustomerLocation;
import com.example.customvalidator.validation.constraint.ValidCustomerLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

public class CustomerLocationValidator implements ConstraintValidator<ValidCustomerLocation, CustomerLocation> {
    @Autowired
    Validator validator;

    @Override
    public boolean isValid(CustomerLocation customerLocation, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;
        Set<ConstraintViolation<CustomerLocation>> constraintViolations = new HashSet();
        constraintViolations =
                validator.validate(customerLocation);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            for (ConstraintViolation<CustomerLocation> violation : constraintViolations) {
                constraintValidatorContext
                        .buildConstraintViolationWithTemplate(violation.getMessageTemplate())
                        .addConstraintViolation();
            }
            isValid = false;
        }
        return isValid;
    }
}
