package com.example.customvalidator.exception;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiErrorResponse {
    private String errorCode;
    private String errorMessage;
    private List<ApiSubError> subErrors;
}
