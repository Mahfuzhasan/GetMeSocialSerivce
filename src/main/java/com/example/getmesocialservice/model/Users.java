package com.example.getmesocialservice.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Users {
    @Id
    private String id;
    private String name;
    @Email(message = "enter valid email")
    private String email;
    @NotEmpty(message = "It cant be empty")
    private String profilePhotoUrl;

    public Users(String name, String email, String profilePhotoUrl) {
        this.name = name;
        this.email = email;
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
}
