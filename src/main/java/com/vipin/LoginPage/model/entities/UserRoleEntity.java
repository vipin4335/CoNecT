package com.vipin.LoginPage.model.entities;

import com.vipin.LoginPage.model.entities.enums.UserRoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    private UserRoleEnum role;


    @Enumerated(EnumType.STRING)

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }



}
