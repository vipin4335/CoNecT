package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.Users;
import com.vipin.LoginPage.repo.UserRepo;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    public Users register(Users user) {
        return repo.save(user);
    }
    public ResponseEntity<String> verify(Users user, HttpServletResponse response) {
        try {
            // Authenticate the user
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );

            if (authentication.isAuthenticated()) {
                // Generate token and set as cookie
                jwtService.generateTokenAsCookie(user.getUsername(), response);
                return ResponseEntity.ok("Login successful. Token set in cookie.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Authentication failed: " + e.getMessage());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed.");
    }

}
