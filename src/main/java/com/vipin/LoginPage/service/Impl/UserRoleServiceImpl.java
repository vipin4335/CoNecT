package com.vipin.LoginPage.service.Impl;

import com.vipin.LoginPage.handler.NotFoundException;
import com.vipin.LoginPage.model.entities.UserRoleEntity;
import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import com.vipin.LoginPage.repo.UserRoleRepository;
import com.vipin.LoginPage.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository ) {
        this.userRoleRepository=userRoleRepository;
    }

    @Override
    public UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum) {
        Optional<UserRoleEntity> byRole=this.userRoleRepository.findByRole(userRoleEnum);
       if(byRole.isPresent())
       {
           return byRole.get();
       }
       else {
          throw new NotFoundException("User role not found. Please seed the roles.");
       }
    }

    @Override
    public UserRoleEntity saveRole(UserRoleEntity userRoleEntity) {
        return this.userRoleRepository.save(userRoleEntity);
    }
}
