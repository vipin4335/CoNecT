package com.vipin.LoginPage.controller;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);



    @PostMapping("/signup")
    @Operation(summary =  "Create new client-user")
    public ResponseEntity<?>signup(@RequestBody AppClientSignUpDto user){
        if(this.userService.userExists(user.getUsername(),user.getEmail()))
        {
            throw new RuntimeException("Username or email address already in use.");
        }
        AppClient client = this.userService.register(user);
        return new ResponseEntity<AppClient>(client, HttpStatus.CREATED);
    }
}
