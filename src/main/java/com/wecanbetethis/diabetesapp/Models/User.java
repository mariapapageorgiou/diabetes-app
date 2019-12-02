package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, max = 20, message = "Please enter a valid username")
    private String username;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User(int id, String username, String email, String password, String verifyPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}