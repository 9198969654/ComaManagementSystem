package com.coma.ComaManagementSystem.service.impl;

import com.coma.ComaManagementSystem.repositories.UserRepository;
import com.coma.ComaManagementSystem.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override  // Override annotation to implement the method from UserDetailsService
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {  // Method declaration
        User user = userRepository.findByUsername(username);  // Fetch the user from the database
        if (user == null) {  // Check if the user exists
            throw new UsernameNotFoundException("User not found");  // Throw an exception if user not found
        }
        return User.builder()  // Create a UserDetails object using Spring Security's User class
                .username(user.getUsername())  // Set the username
                .password(user.getPassword())  // Set the password
                .roles("USER")  // Set roles (authorities)
                .build();  // Build and return the UserDetails object
    }

}
