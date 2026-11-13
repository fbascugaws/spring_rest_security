package com.spring.spring_rest_security.controller;

import com.spring.spring_rest_security.entity.StudentErrorResponse;
import com.spring.spring_rest_security.exception.StudentNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * StudentExceptionHandler
 * <p>
 * Global exception handler for student-related REST controllers.
 * Intercepts exceptions thrown during request processing and formats them
 * into standardized HTTP error responses.
 * </p>
 * 
 * @author Felisa Bascug
 */
@ControllerAdvice 
public class StudentExceptionHandler {

    /**
     * Handles generic exceptions, such as type mismatches in request 
     * parameters or path variables.
     *
     * @param ex the caught generic {@link Exception}
     * @return a {@link ResponseEntity} containing a 
     *          {@link StudentErrorResponse} with HTTP 400 (Bad Request)
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
        
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid data. Only integers are accepted.");
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

    }

    /**
     * Handles exceptions thrown when a requested student record cannot be 
     * found.
     *
     * @param ex the caught {@link StudentNotFoundException} containing details
     *          about the missing student
     * @return a {@link ResponseEntity} containing a 
     *          {@link StudentErrorResponse} with HTTP 404 (Not Found)
     */
    @ExceptionHandler 
    public ResponseEntity<StudentErrorResponse> handleException(
            StudentNotFoundException ex) {
        
        StudentErrorResponse err = new StudentErrorResponse();

        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

    }

    /**
     * Handles validation failures for request bodies annotated with 
     * {@code @Valid}.
     * Extracts field-level validation errors and returns them as key-value 
     * pairs in JSON format.
     *
     * @param ex the {@link MethodArgumentNotValidException} containing binding
     *          and validation errors
     * @return a {@link ResponseEntity} containing a map of field names to 
     *          error messages with HTTP 400 (Bad Request)
     */
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions
            (MethodArgumentNotValidException ex) {

        Map<String, String> err = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            err.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
        
}
