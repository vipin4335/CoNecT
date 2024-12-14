package com.vipin.LoginPage.controller;

import com.vipin.LoginPage.service.Impl.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloController {
    @Autowired
    CloudinaryService cloudinary;
    @GetMapping({"hello","/"})
    public String greet(HttpServletRequest request) {
        return "Hello World "+request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request) {
        return "Telusko "+request.getSession().getId();
    }
    @PostMapping("upload/image")
    public String uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = cloudinary.uploadImage(file); // Call the CloudinaryService to upload the image
            return "Image uploaded successfully: " + imageUrl;
        } catch (Exception e) {
            return "Failed to upload image: " + e.getMessage();
        }
    }


}