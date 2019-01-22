# spring-custom-validator
Custom validator using spring annotations

# Custom annotation

A custom annotation "NumericString" is created which checks if the string passed is numeric or not using custom validator.

The custom annotation is applied to below attributes of the CustomerLocation model:
locationId, countryCode & postCode

Also, "ValidCustomerLocation" custom annotation will validate the incoming CustomerLocation object for any contraint violation.


Once the application is running on port 8080. Try sending the below POST request:

URL: localhost:8080/v1/validate

Request Body: 
{
	"locationId":"aa",
	"countryCode":"sns",
	"postCode":"ss"
}

Below response would be received:

{
    "errorCode": "400 BAD_REQUEST",
    "errorMessage": "Validation Errors",
    "subErrors": [
        {
            "object": "customerLocation",
            "field": "locationId",
            "rejectedValue": "locationId",
            "message": "locationId should be numeric"
        },
        {
            "object": "customerLocation",
            "field": "city",
            "rejectedValue": "city",
            "message": "city cannot not be empty"
        },
        {
            "object": "customerLocation",
            "field": "postCode",
            "rejectedValue": "postCode",
            "message": "postCode should be numeric"
        },
        {
            "object": "customerLocation",
            "field": "countryCode",
            "rejectedValue": "countryCode",
            "message": "countryCode should be numeric"
        }
    ]
}


