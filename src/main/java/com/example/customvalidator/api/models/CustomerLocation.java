package com.example.customvalidator.api.models;

import com.example.customvalidator.validation.constraint.NumericString;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerLocation {
    @NumericString(message = "locationId should be numeric")
    private String locationId;
    @NotBlank(message = "city cannot not be empty")
    private String city;
    @NumericString(message = "countryCode should be numeric")
    private String countryCode;
    @NumericString(message = "postCode should be numeric")
    private String postCode;
}
