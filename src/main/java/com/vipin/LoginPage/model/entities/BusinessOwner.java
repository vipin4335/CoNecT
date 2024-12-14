package com.vipin.LoginPage.model.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "business_owners")
@Setter
public class BusinessOwner extends UserEntity {
    private String businessName;
    private String address;
    private Set<Hobby> hobby_offers;

    public BusinessOwner(String username, String email, List<UserRoleEntity> roles, String password, String businessName, String address, Set<Hobby> hobby_offers) {
        super(username, email, roles, password);
        this.businessName = businessName;
        this.address = address;
        this.hobby_offers = hobby_offers;
    }

    @Column(name = "business_name",nullable = false)
    public String getBusinessName() {
        return businessName;
    }

    @Column(nullable = false)
    public String getAddress() {
        return address;
    }
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    public Set<Hobby> getHobby_offers() {
        return hobby_offers;
    }
}
