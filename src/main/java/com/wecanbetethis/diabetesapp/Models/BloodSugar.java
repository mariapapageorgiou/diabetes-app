package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class BloodSugar {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message="Entry must be between 0 and 600")
    private int numberEntry;

    @NotNull
    private String date;

    @NotNull
    private String time;

    @NotNull
    private Meals meals;

    public BloodSugar(int numberEntry, Meals meals, String date, String time) {
        this.numberEntry = numberEntry;
        this.date = date;
        this.time = time;
        this.meals = meals;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }
}
