package com.vipin.LoginPage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BusinessRegisterDto {
    private String username;
    private String businessName;
    private String address;
    private String email;
    private String password;
}
