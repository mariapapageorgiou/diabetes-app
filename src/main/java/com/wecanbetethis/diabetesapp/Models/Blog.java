package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Optional;

@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 5, max = 50)
    private String title;

    @NotNull
    @Size(min = 10, max = 1000)
    private String body;
//
//    @ManyToOne
//    private User user;

    public Blog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUser(User user) {
    }
}