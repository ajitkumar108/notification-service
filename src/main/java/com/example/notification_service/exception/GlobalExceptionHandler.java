package com.example.notification_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, String>>
handleValidationException(
        MethodArgumentNotValidException ex) {

    Map<String, String> errors = new HashMap<>();

    ex.getBindingResult()
      .getFieldErrors()
      .forEach(error ->
           errors.put(
               error.getField(),
               error.getDefaultMessage()));

    return ResponseEntity
            .badRequest()
            .body(errors);
}
    @ExceptionHandler(
            NotificationException.class)
    public ResponseEntity< Map<String, String>> handleException(
            NotificationException ex) {

        Map<String, String> response =
                new HashMap<>();

        response.put(
                "message",
                ex.getMessage());

        return new ResponseEntity<>(
            response, ex.getStatus());
    }
}