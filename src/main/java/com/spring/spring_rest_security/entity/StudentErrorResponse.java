package com.spring.spring_rest_security.entity;

/**
 * StudentErrorResponse
 * <p>
 * Data model representing a standardized error response returned by REST 
 * endpoints when an exception occurs during student request processing.
 * </p>
 * 
 * @author Felisa Bascug
 */
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
    
    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "StudentErrorResponse [status=" + status 
            + ", message=" + message + ", timeStamp=" + timeStamp + "]";
    }

}
