package com.vipin.LoginPage.repo;

import com.vipin.LoginPage.model.entities.AppClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppClientRepository extends JpaRepository<AppClient,Long> {

}
