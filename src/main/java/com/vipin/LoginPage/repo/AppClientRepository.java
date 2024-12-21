package com.vipin.LoginPage.repo;

import com.vipin.LoginPage.model.entities.AppClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppClientRepository extends JpaRepository<AppClient,Long> {

    Optional<AppClient> findByUsername(String username);
}
