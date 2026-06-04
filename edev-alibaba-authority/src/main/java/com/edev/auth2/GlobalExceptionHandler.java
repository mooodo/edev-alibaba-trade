package com.edev.auth2;

import com.edev.support.exception.ValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidException.class)
    public ResponseEntity<String> handleValidException(ValidException ex) {
        return ResponseEntity.badRequest().body("not valid: "+ex.getMessage());
    }
}
