package com.vipin.LoginPage.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@MappedSuperclass
@NoArgsConstructor
public class BaseEntity {
    protected Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
