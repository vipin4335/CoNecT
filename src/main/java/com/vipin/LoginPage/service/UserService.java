package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.dto.BusinessRegisterDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.BusinessOwner;
import com.vipin.LoginPage.model.entities.UserEntity;

public interface UserService {

    boolean userExists(String username, String email);

    AppClient register(AppClientSignUpDto user);

    boolean businessExists(String businessName);

    BusinessOwner registerBusiness(BusinessRegisterDto business);

    UserEntity findUserByUsername(String username);
}
