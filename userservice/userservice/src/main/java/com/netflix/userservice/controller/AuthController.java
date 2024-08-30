package com.netflix.userservice.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.userservice.config.JwtProvider;
import com.netflix.userservice.entities.User;
import com.netflix.userservice.repository.UserRepository;
import com.netflix.userservice.request.LoginRequest;
import com.netflix.userservice.response.AuthResponse;
import com.netflix.userservice.service.CustomUserDetailsService;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/auth")
public class AuthController {
   
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtTokenProvider;
    private final CustomUserDetailsService customUserDetails;
    
    public AuthController(UserRepository userRepository, PasswordEncoder passwordEncoder,
                          JwtProvider jwtTokenProvider, CustomUserDetailsService customUserDetails) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.customUserDetails = customUserDetails;
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> createUserHandler(@Valid @RequestBody User user) {
        User isEmailExist = userRepository.findByEmail(user.getEmail());
        if (isEmailExist != null) {
            log.error("Email is already used: {}", user.getEmail());
            throw new RuntimeException("Email Is Already Used With Another Account"); // Replace with a custom exception
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDatetime(LocalDateTime.now());
        userRepository.save(user);
        
        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtTokenProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(jwt, "Register Success");
        
        return ResponseEntity.status(HttpStatus.CREATED).body(authResponse);
    }
    
    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtTokenProvider.generateToken(authentication);
        AuthResponse authResponse = new AuthResponse(jwt, "Login Success");
        
        return ResponseEntity.ok(authResponse);
    }
    
    private Authentication authenticate(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            log.error("Invalid username or password for user: {}", username);
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
