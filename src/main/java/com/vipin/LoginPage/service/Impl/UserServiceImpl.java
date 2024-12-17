package com.vipin.LoginPage.service.Impl;

import com.vipin.LoginPage.handler.NotFoundException;
import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.dto.BusinessRegisterDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.UserEntity;
import com.vipin.LoginPage.model.entities.UserRoleEntity;
import com.vipin.LoginPage.model.entities.BusinessOwner;
import com.vipin.LoginPage.model.entities.enums.GenderEnum;
import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import com.vipin.LoginPage.repo.AppClientRepository;
import com.vipin.LoginPage.repo.BusinessOwnerRepository;
import com.vipin.LoginPage.repo.UserRepository;
import com.vipin.LoginPage.service.UserRoleService;
import com.vipin.LoginPage.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppClientRepository appClientRepository;
    private final BusinessOwnerRepository businessOwnerRepository;



    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserRoleService userRoleService, ModelMapper modelMapper,PasswordEncoder passwordEncoder,AppClientRepository appClientRepository,BusinessOwnerRepository businessOwnerRepository) {
        this.userRepository = userRepository;
        this.userRoleService=userRoleService;
        this.modelMapper=modelMapper;
        this.passwordEncoder=passwordEncoder;
        this.appClientRepository=appClientRepository;
        this.businessOwnerRepository=businessOwnerRepository;
    }
    @Override
    public List<UserEntity> seedUsersAndUserRoles() {
        System.out.println("started filling in service");
        List<UserEntity> seededUsers = new ArrayList<>();

        if (appClientRepository.count() == 0) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRole(UserRoleEnum.USER);
            UserRoleEntity userRole = this.userRoleService.saveRole(userRoleEntity);
            UserRoleEntity userRoleEntity2 = new UserRoleEntity();
            userRoleEntity2.setRole(UserRoleEnum.ADMIN);
            UserRoleEntity adminRole = this.userRoleService.saveRole(userRoleEntity2);
            AppClient user = new AppClient();
            user.setUsername("user");
            user.setEmail("n13@gmail.com");
            user.setPassword(this.passwordEncoder.encode("topsecret"));
            user.setRoles(List.of(userRole));
            user.setFullName("Nikoleta Doykova");
            user.setGender(GenderEnum.FEMALE);

            appClientRepository.save(user);
            seededUsers.add(user);


        }
        if (businessOwnerRepository.count() == 0) {
            UserRoleEntity userRoleEntity3 = new UserRoleEntity();
            userRoleEntity3.setRole(UserRoleEnum.BUSINESS_USER);
            UserRoleEntity businessRole = this.userRoleService.saveRole(userRoleEntity3);
            //business_user
            BusinessOwner business_user = new BusinessOwner();
            business_user.setUsername("business");
            business_user.setEmail("n10@gamil.com");
            business_user.setPassword(this.passwordEncoder.encode("topsecret"));
            business_user.setRoles(List.of(businessRole));
            business_user.setBusinessName("My Business name");
            business_user.setAddress("My business address");
            businessOwnerRepository.save(business_user);
            seededUsers.add(business_user);
        }
        return seededUsers;
    }
    @Override
    public AppClient register(AppClientSignUpDto user) {
        UserRoleEntity userRole = this.userRoleService.getUserRoleByEnumName(UserRoleEnum.USER);
        AppClient appClient = this.modelMapper.map(user,AppClient.class);
        appClient.setRoles(List.of(userRole));
        appClient.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return appClientRepository.save(appClient);
    }

    @Override
    public boolean userExists(String username, String email) {
        Optional<UserEntity> byUsername = this.userRepository.findByUsername(username);
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(email);
        return byUsername.isPresent() || byEmail.isPresent();
    }

    @Override
    public boolean businessExists(String businessName) {
         Optional<BusinessOwner> byBusinessName=this.businessOwnerRepository.findByBusinessName(businessName);
          return byBusinessName.isPresent();
    }

    @Override
    public BusinessOwner registerBusiness(BusinessRegisterDto business) {
        UserRoleEntity businessUserRole =this.userRoleService.getUserRoleByEnumName(UserRoleEnum.BUSINESS_USER);
        BusinessOwner businessOwner=this.modelMapper.map(business,BusinessOwner.class);
        businessOwner.setRoles(List.of(businessUserRole) );
        businessOwner.setPassword(this.passwordEncoder.encode(business.getPassword()));
        return businessOwnerRepository.save(businessOwner);
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        Optional<UserEntity>byUsername=this.userRepository.findUserByUsername(username);
        if(byUsername.isPresent())
            return byUsername.get();
        else
            throw new NotFoundException("Can not find the user with the Username");
    }

}
