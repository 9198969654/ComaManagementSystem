package com.coma.ComaManagementSystem.controller;

import com.coma.ComaManagementSystem.entities.User;
import com.coma.ComaManagementSystem.repositories.UserRepository;
import com.coma.ComaManagementSystem.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                    loginRequest.getPassword()));
           String jwt =  jwtUtils.generateToken(authentication.getName());
           Map<String , String> response = new HashMap<>();
           response.put("token", jwt);
           return response;
        }catch (AuthenticationException e){
            throw new RuntimeException("Invalid Credentials");
        }
    }

    @PostMapping("/register")
    public String Register(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User Registered Successfully";

    }

}





























