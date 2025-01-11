package com.vilai.quote.exceptions;

import com.chargebee.APIException;
import com.chargebee.exceptions.InvalidRequestException;
import com.chargebee.exceptions.OperationFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request: " + e.getMessage());
    }

    @ExceptionHandler(OperationFailedException.class)
    public ResponseEntity<String> handleOperationFailedException(OperationFailedException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Operation failed: " + e.getMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<String> handleAPIException(APIException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Chargebee API error: " + e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + e.getMessage());
    }
}
