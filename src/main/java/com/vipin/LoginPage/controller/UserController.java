package com.vipin.LoginPage.controller;

import com.vipin.LoginPage.model.Users;
import com.vipin.LoginPage.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return service.register(user);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users user, HttpServletResponse response) {
        return service.verify(user, response);
    }
}
