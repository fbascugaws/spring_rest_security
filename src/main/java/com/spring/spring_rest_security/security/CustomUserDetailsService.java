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
 * 
 */
@Service 
public class CustomUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepo;    

    public CustomUserDetailsService(AuthUserRepository authUserRepo) {
        this.authUserRepo = authUserRepo;
    }

    /**    
     * @param username
     * @return 
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
     * 
     * @param roles
     * @return
     */
    private Collection<GrantedAuthority> mapRolesToAuthorities(
            List<Auth_Role> roles) {
        
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority(role.getName()))
            .collect(Collectors.toList());

    }
    
}
