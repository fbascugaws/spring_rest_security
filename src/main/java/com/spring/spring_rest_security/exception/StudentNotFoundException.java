package com.spring.spring_rest_security.exception;

/**
 * StudentNotFoundException
 * <p>
 * Custom runtime exception thrown when a requested student record cannot be 
 * found in the system.
 * </p>
 * 
 * @author Felisa Bascug
 */
public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -2690100046087976236L;

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
