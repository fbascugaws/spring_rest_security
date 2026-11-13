package com.spring.spring_rest_security.repository;

import com.spring.spring_rest_security.entity.Auth_Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthRoleRepository extends JpaRepository<Auth_Role, Long> {

    Optional<Auth_Role> findByName(String name);
    Boolean existsByName(String name);

}
