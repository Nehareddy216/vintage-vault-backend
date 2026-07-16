package com.vintagevault.exception;

import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {


    // Validation Errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex) {


        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));


        ErrorResponse error = new ErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value()
        );


        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }



    // Duplicate Email / Phone Number
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolation(
            DataIntegrityViolationException ex) {


        String errorMessage = ex.getMessage();


        String message;


        if (errorMessage.contains("email")) {

            message = "This email is already registered. Please use another email.";

        }
        else if (errorMessage.contains("phone_number")) {

            message = "This phone number is already registered. Please use another phone number.";

        }
        else {

            message = "This information is already registered.";

        }


        ErrorResponse error = new ErrorResponse(
                message,
                HttpStatus.BAD_REQUEST.value()
        );


        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }



    // Runtime Exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(
            RuntimeException ex) {


        ErrorResponse error = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );


        return new ResponseEntity<>(
                error,
                HttpStatus.BAD_REQUEST
        );
    }



    // Any Other Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex) {


        ErrorResponse error = new ErrorResponse(
                "Something went wrong. Please try again.",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );


        return new ResponseEntity<>(
                error,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

}