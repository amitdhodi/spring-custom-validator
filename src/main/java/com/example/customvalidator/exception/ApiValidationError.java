package com.example.customvalidator.exception;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;
}
