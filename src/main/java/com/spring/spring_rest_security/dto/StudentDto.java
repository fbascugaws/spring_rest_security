package com.spring.spring_rest_security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

/**
 * StudentDto
 * <p>
 * Acts as a container for data that can be passed between different parts
 * of an application, or over a network.
 * The DTO (Data Transfer Object) acts as a protective shield and filter.
 * </p>
 * 
 * @author Felisa Bascug
 */
public class StudentDto {
    
    private Long id;

    @Size (min = 2, max = 50, message = "Must be 2 to 50 characters.")
    private String firstName;
    
    @Size (min = 2, max = 50, message = "Must be 2 to 50 characters.")
    private String lastName;

    @Email (message = "Email is required and should be valid.")
    private String email;
    
    public StudentDto() {
    }

    public StudentDto(Long id, String firstName, String lastName, 
            String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "StudentDto [id=" + id + ", firstName=" + firstName 
            + ", lastName=" + lastName + ", email=" + email + "]";
    }

}
