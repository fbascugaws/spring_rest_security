package com.spring.spring_rest_security.repository;

import com.spring.spring_rest_security.entity.Auth_Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AuthRoleRepository
 * <p>
 * JPA entity representing an authorization role or authority in the system.
 * Maps to the {@code auth_role} database table.
 * <p>
 *  
 * @author Felisa Bascug
 */
public interface AuthRoleRepository extends JpaRepository<Auth_Role, Long> {

    Optional<Auth_Role> findByName(String name);
    Boolean existsByName(String name);

}
