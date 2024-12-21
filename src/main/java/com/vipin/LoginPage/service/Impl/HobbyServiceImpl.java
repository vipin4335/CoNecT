package com.vipin.LoginPage.service.Impl;

import com.vipin.LoginPage.model.entities.AppClient;
import com.vipin.LoginPage.model.entities.Hobby;

import com.vipin.LoginPage.repo.HobbyRepository;
import com.vipin.LoginPage.service.HobbyService;
import com.vipin.LoginPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class HobbyServiceImpl implements HobbyService {
   private final HobbyRepository hobbyRepository;
    private final UserService userService;

    @Autowired
    public HobbyServiceImpl(HobbyRepository hobbyRepository,UserService userService) {
        this.hobbyRepository = hobbyRepository;
        this.userService =userService;
    }

    @Override
    public Set<Hobby> getAllHobbieMatchesForClient(String username) {
        AppClient currentUserAppClient = this.userService.findAppClientByUserName(username);
        return currentUserAppClient.getHobby_matches();

    }

    @Override
    public Set<Hobby> getAllHobbiesForBusiness(String username) {
        return this.hobbyRepository.findAllByCreator(username);
    }
}
