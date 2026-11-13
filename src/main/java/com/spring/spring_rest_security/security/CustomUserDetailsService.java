package com.spring.spring_rest_security.security;

import com.spring.spring_rest_security.entity.Auth_Role;
import com.spring.spring_rest_security.entity.Auth_User;
import com.spring.spring_rest_security.repository.AuthUserRepository;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * CustomUserDetailsService
 * <p>
 * Custom implementation of Spring Security's {@link UserDetailsService} 
 * responsible for loading user-specific authentication and authorization data
 * from the database.
 * </p>
 * 
 * @author Felisa Bascug
 */
@Service 
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepo;    

    public CustomUserDetailsService(AuthUserRepository authUserRepo) {
        this.authUserRepo = authUserRepo;
    }

    /**
     * Locates a user based on their username and converts the entity into a 
     * Spring Security {@link UserDetails} object populated with their 
     * credentials and granted authorities.
     *
     * @param username the username identifying the user whose data is required
     * @return a populated {@link UserDetails} instance for authentication
     * @throws UsernameNotFoundException if no user is found with the specified
     *          username
     */
    @Override
    public UserDetails loadUserByUsername(String username) 
            throws UsernameNotFoundException {
        
        Auth_User user = authUserRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(
                "Username " + username + " does not exist."
            ));

        return new User(
            user.getUsername(), user.getPassword(), 
            mapRolesToAuthorities(user.getRoles())
        );

    }

    /**
     * Converts a list of {@link Auth_Role} entities into a collection of 
     * Spring Security {@link GrantedAuthority} objects.
     *
     * @param roles the list of roles assigned to a user
     * @return a collection of {@link SimpleGrantedAuthority} instances 
     *          representing the user's roles
     */
    private Collection<GrantedAuthority> mapRolesToAuthorities(
            List<Auth_Role> roles) {
        
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());

    }
    
}
