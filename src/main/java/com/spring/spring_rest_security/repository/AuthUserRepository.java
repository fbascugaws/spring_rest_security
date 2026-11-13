package com.spring.spring_rest_security.repository;

import com.spring.spring_rest_security.entity.Auth_User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AuthUserRepository
 * <p>
 * Spring Data JPA repository for managing {@link Auth_User} entities.
 * Provides standard CRUD operations along with custom query methods for user
 * lookup and validation.
 * </p>
 * 
 * @author Felisa Bascug
 */
public interface AuthUserRepository extends JpaRepository<Auth_User, Long> {

    Optional<Auth_User> findByUsername(String username);
    Boolean existsByUsername(String username);

}
