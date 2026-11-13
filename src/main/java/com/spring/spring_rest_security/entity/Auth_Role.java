package com.spring.spring_rest_security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Auth_Role
 * <p>
 * JPA entity representing an authorization role or authority in the system.
 * Maps to the {@code auth_role} database table.
 * </p>
 * 
 * @author Felisa Bascug
 */
@Entity 
@Table (name = "auth_role")
public class Auth_Role {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Auth_Role() {
    }

    public Auth_Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

}
