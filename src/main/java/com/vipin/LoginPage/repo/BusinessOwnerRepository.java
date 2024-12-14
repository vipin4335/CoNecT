package com.vipin.LoginPage.repo;

import com.vipin.LoginPage.model.entities.BusinessOwner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusinessOwnerRepository extends JpaRepository<BusinessOwner,Long> {
    Optional<BusinessOwner> findByBusinessName(String businessName);
}
