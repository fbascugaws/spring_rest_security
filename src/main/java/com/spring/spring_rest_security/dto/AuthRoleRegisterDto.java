package com.spring.spring_rest_security.dto;

/**
 * AuthRoleRegisterDto
 * Data Transfer Object (DTO) for capturing user registration credentials.
 * 
 * @author Felisa Bascug
 */
public class AuthRoleRegisterDto {

    private String name;

    public AuthRoleRegisterDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
