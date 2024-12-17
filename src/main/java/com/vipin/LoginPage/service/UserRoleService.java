package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.entities.UserRoleEntity;
import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import org.springframework.stereotype.Service;


public interface UserRoleService {
    UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum);
    UserRoleEntity saveRole(UserRoleEntity userRoleEntity);

}
