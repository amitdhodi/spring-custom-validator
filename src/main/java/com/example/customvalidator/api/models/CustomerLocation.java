package com.example.customvalidator.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CustomerLocation {
    @NotBlank(message = "locationId cannot not be empty")
    private String locationId;
    @NotBlank(message = "city cannot not be empty")
    private String city;
    @NotBlank(message = "countryCode cannot not be empty")
    private String countryCode;
    @NotBlank(message = "postCode cannot not be empty")
    private String postCode;
}
