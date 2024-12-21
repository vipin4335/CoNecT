package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.dto.BusinessRegisterDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.BusinessOwner;
import com.vipin.LoginPage.model.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserEntity> seedUsersAndUserRoles();
    boolean userExists(String username, String email);

    AppClient register(AppClientSignUpDto user);

    boolean businessExists(String businessName);

    BusinessOwner registerBusiness(BusinessRegisterDto business);

    UserEntity findUserByUsername(String username);


    AppClient findAppClientByUserName(String username);
}
