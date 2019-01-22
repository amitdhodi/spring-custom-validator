package com.example.customvalidator.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
@RestControllerAdvice
public class ApiErrorHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<ApiSubError> apiValidationErrors = new ArrayList<>();
        Optional<List<FieldError>> fieldErrors = Optional.ofNullable(ex.getBindingResult().getFieldErrors());
        if (fieldErrors.isPresent()) {
            ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
                apiValidationErrors.add(ApiValidationError.builder().field(fieldError.getField())
                        .message(fieldError.getDefaultMessage())
                        .object(fieldError.getObjectName())
                        .rejectedValue(fieldError.getField())
                        .build());
            });
        }
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .errorMessage("Validation Errors")
                .subErrors(apiValidationErrors)
                .build();
        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
