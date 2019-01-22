package com.example.customvalidator.validation.constraint;

import com.example.customvalidator.validation.validator.CustomerLocationValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CustomerLocationValidator.class})
@Documented
public @interface ValidCustomerLocation {
    String message() default "Invalid customer location";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
