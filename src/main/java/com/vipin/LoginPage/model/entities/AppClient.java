package com.vipin.LoginPage.model.entities;

import com.vipin.LoginPage.model.entities.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Test;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
@Entity
@Table(name ="app_clients")
@NoArgsConstructor
public class AppClient extends UserEntity implements Serializable {
    private String fullName;
    private GenderEnum gender;
    private Test testResults;
    private Set<Hobby> hobby_matches;
    private List<Hobby> saved_hobbies;

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
    @OneToOne(cascade = CascadeType.REMOVE)
    public Test getTestResults() {
        return testResults;
    }

    public void setTestResults(Test testResults) {
        this.testResults = testResults;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Hobby> getHobby_matches() {
        return hobby_matches;
    }

    public void setHobby_matches(Set<Hobby> hobby_matches) {
        this.hobby_matches = hobby_matches;
    }

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<Hobby> getSaved_hobbies() {
        return saved_hobbies;
    }

    public void setSaved_hobbies(List<Hobby> saved_hobbies) {
        this.saved_hobbies = saved_hobbies;
    }
}
