package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.entities.AppClient;

public interface UserService {

    boolean userExists(String username, String email);

    AppClient register(AppClientSignUpDto user);
}
