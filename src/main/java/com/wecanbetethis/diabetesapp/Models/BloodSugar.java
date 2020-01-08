package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class BloodSugar {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private int numberEntry;

    @NotNull
    private Meals meals;

//    @NotNull
//    private Date date;

    public BloodSugar(int numberEntry, Meals meals) {
        this.numberEntry = numberEntry;
        this.meals = meals;
//        this.date = date;
    }

    public BloodSugar() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberEntry() {
        return numberEntry;
    }

    public void setNumberEntry(int numberEntry) {
        this.numberEntry = numberEntry;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
}
