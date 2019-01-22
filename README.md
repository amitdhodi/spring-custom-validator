# spring-custom-validator
Custom validator using spring annotations

# Custom annotation

A custom annotation "NumericString" is created which checks if the string passed is numeric or not using custom validator.

The custom annotation is applied to below attributes of the CustomerLocation model:
locationId, countryCode & postCode

Also, "ValidCustomerLocation" custom annotation will validate the incoming CustomerLocation object for any contraint violation.

