package com.example.customvalidator.api.controller;

import com.example.customvalidator.api.models.CustomerLocation;
import com.example.customvalidator.validation.constraint.ValidCustomerLocation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    @PostMapping(value="/v1/validate", produces = "application/json")
    public ResponseEntity<String> validateCustomerLocation(@ValidCustomerLocation @RequestBody CustomerLocation customerLocation){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
