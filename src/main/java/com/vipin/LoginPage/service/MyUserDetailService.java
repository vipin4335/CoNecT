package com.vipin.LoginPage.service;

import com.vipin.LoginPage.model.UserPrinciple;
import com.vipin.LoginPage.model.Users;
import com.vipin.LoginPage.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Users users=repo.findByUsername(username);
          if(users==null){
              throw new UsernameNotFoundException("user not found");
          }
      return new UserPrinciple(users);
    }
}
