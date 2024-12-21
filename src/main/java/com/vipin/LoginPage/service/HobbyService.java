package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.entities.Hobby;

import java.util.Set;

public interface HobbyService {
    Set<Hobby>getAllHobbieMatchesForClient(String username);

    Set<Hobby> getAllHobbiesForBusiness(String username);
}
