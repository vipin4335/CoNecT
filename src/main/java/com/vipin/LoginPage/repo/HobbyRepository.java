package com.vipin.LoginPage.repo;

import com.vipin.LoginPage.model.entities.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface HobbyRepository extends JpaRepository<Hobby,Long> {

    Set<Hobby> findAllByCreator(String creator);
}
