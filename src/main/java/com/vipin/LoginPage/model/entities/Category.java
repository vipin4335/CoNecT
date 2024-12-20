package com.vipin.LoginPage.model.entities;


import com.vipin.LoginPage.model.entities.enums.CategoryNameEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;

    public Category(CategoryNameEnum categoryNameEnum) {
        this.name = categoryNameEnum;
    }

    public Category() {
    }

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
}
