package com.vipin.LoginPage.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "users")
public class UserEntity {
    private String username;
    private String email;
    private List<UserRoleEntity> roles = new ArrayList<>();
    private String password;



}
