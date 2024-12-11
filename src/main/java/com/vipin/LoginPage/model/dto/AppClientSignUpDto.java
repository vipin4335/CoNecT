package com.vipin.LoginPage.model.dto;

import com.vipin.LoginPage.model.entities.GenderEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AppClientSignUpDto {
    private String username;
    private String fullName;
    private GenderEnum gender;
    private String email;
    private String password;
}
