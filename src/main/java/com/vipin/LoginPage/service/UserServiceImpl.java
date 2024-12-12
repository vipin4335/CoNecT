package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.dto.AppClientSignUpDto;
import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.UserEntity;
import com.vipin.LoginPage.model.entities.UserRoleEntity;
import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import com.vipin.LoginPage.repo.AppClientRepository;
import com.vipin.LoginPage.repo.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AppClientRepository appClientRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,UserRoleService userRoleService, ModelMapper modelMapper,PasswordEncoder passwordEncoder,AppClientRepository appClientRepository) {
        this.userRepository = userRepository;
        this.userRoleService=userRoleService;
        this.modelMapper=modelMapper;
        this.passwordEncoder=passwordEncoder;
        this.appClientRepository=appClientRepository;
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


}
