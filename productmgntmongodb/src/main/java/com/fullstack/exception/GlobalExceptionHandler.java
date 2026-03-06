package com.fullstack.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleCustomException(RecordNotFoundException exception) {
        return new ResponseEntity<>("errors{}: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
