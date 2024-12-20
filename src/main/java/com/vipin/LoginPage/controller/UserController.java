package com.vipin.LoginPage.controller;

import com.vipin.LoginPage.JWT.JWTUtility;
import com.vipin.LoginPage.JWT.JwtRequest;
import com.vipin.LoginPage.JWT.JwtResponse;
import com.vipin.LoginPage.Security.CoNectUserDetailService;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final CoNectUserDetailService coNectUserDetailService;
    private final JWTUtility jwtUtility;

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager,CoNectUserDetailService coNectUserDetailService,JWTUtility jwtUtility) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.coNectUserDetailService=coNectUserDetailService;
        this.jwtUtility =jwtUtility;
    }

    @PostMapping("/signup")
    @CrossOrigin
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
        BusinessOwner businessOwner=this.userService.registerBusiness(business);
        return new ResponseEntity<BusinessOwner>(businessOwner,HttpStatus.CREATED);
    }
    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate user and get JWT Token")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception
    {
       try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                          jwtRequest.getUsername(),
                           jwtRequest.getPassword()
                   ));
       }catch (BadCredentialsException e)
       {
           throw new BadCredentialsException("INVALID CREDENTIALS",e);
       }
       final UserDetails userDetails = coNectUserDetailService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }
    @PostMapping("/login")
    @Operation(summary = "Login based on user role after authentication",security = @SecurityRequirement(name = "bearerAuth"))
    @CrossOrigin(origins = "http://localhost:4200")
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
