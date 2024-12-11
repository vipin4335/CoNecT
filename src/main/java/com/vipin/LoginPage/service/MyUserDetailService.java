package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.UserPrinciple;
import com.vipin.LoginPage.model.entities.UserEntity;
import com.vipin.LoginPage.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          UserEntity users=repo.findByUsername(username);
          if(users==null){
              throw new UsernameNotFoundException("user not found");
          }
      return new UserPrinciple(users);
    }
}
