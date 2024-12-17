package com.vipin.LoginPage.DBInit;

import com.vipin.LoginPage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;

    @Autowired
    public DBInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("started filling");
        this.userService.seedUsersAndUserRoles();
    }
}
