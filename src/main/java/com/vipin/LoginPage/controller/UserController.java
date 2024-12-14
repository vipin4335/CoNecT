package com.vipin.LoginPage.controller;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.dto.BusinessRegisterDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.BusinessOwner;
import com.vipin.LoginPage.model.entities.UserEntity;
import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import com.vipin.LoginPage.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserService userService;

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
    @PostMapping("/register")
    @Operation(summary = "Create new business-user")
    public ResponseEntity<?>registerBusiness(@RequestBody BusinessRegisterDto business){
        if (this.userService.businessExists(business.getBusinessName()) || this.userService.userExists(business.getUsername(), business.getEmail())) {
            throw new RuntimeException("Username or email address already in use.");
        }
        BusinessOwner businessOwner=this.userService.registerBusiness(business)
        return new ResponseEntity<BusinessOwner>(businessOwner,HttpStatus.CREATED);
    }
    @PostMapping("/login")
    @Operation(summary = "Login based on user role after authentication",security = @SecurityRequirement(name = "bearerAuth"))
    public String logInUser(@RequestParam String username )
    {
        UserEntity userByUsername= this.userService.findUserByUsername(username);
        if(userByUsername.getRoles().stream()
                .anyMatch(userRoleEntity ->userRoleEntity.getRole().equals(UserRoleEnum.USER) ))
        {
            return "user";
        }
        if(userByUsername.getRoles().stream()
                .anyMatch(userRoleEntity -> userRoleEntity.getRole().equals(UserRoleEnum.BUSINESS_USER)))
        {
            return "BUSINESS_USER";
        }
        return null;
    }
}
