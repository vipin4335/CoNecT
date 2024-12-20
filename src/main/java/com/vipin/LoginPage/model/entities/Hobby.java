package com.vipin.LoginPage.model.entities;

import jakarta.persistence.*;

import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "hobbies")
@Setter
public class Hobby extends BaseEntity{
    private String name;
    private String slogan;
    private String intro;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    private String creator;
    private BigDecimal price;

    @ManyToOne
    private Location location;

    private String profileImgUrl;
    private String galleryImgUrl1;
    private String galleryImgUrl2;
    private String galleryImgUrl3;
    private String profileImg_id;
    private String galleryImg1_id;
    private String galleryImg2_id;
    private String galleryImg3_id;
    private String contactInfo;

    public Hobby() {
    }

    @Column(name = "profile_img_id")
    public String getProfileImg_id() {
        return profileImg_id;
    }



    @Column(name = "img1_id")
    public String getGalleryImg1_id() {
        return galleryImg1_id;
    }



    @Column(name = "img2_id")
    public String getGalleryImg2_id() {
        return galleryImg2_id;
    }



    @Column(name = "img3_id")
    public String getGalleryImg3_id() {
        return galleryImg3_id;
    }



    @Column(name = "profile_image_url")
    public String getProfileImgUrl() {
        return profileImgUrl;
    }



    @Column(nullable = false)
    public String getName() {
        return name;
    }



    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }




    public Category getCategory() {
        return category;
    }



    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }



    @Column
    public String getCreator() {
        return creator;
    }




    public Location getLocation() {
        return location;
    }



    @Column(name = "slogan")
    public String getSlogan() {
        return slogan;
    }




    @Column(columnDefinition = "TEXT")
    public String getIntro() {
        return intro;
    }



    @Column(name = "gallery_image_url_1")
    public String getGalleryImgUrl1() {
        return galleryImgUrl1;
    }



    @Column(name = "gallery_image_url_2")
    public String getGalleryImgUrl2() {
        return galleryImgUrl2;
    }



    @Column(name = "gallery_image_url_3")
    public String getGalleryImgUrl3() {
        return galleryImgUrl3;
    }


    @Column(name = "contact_info", columnDefinition = "TEXT")

    public String getContactInfo() {
        return contactInfo;
    }



}
