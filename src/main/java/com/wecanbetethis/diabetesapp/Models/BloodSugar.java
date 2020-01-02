package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BloodSugar {

    @Id
    @GeneratedValue
    private int id;

//    public enum Entry {
//        FASTING, BREAKFAST, MORNING_SNACK, LUNCH, AFTERNOON_SNACK, DINNER, EVENING_SNACK
//    }
//
//    String Entry;
//    Integer bloodSugarEntry;
//
//    public BloodSugar() {
//    }
//
//    public BloodSugar(String entry, Integer bloodSugarEntry) {
//        Entry = entry;
//        this.bloodSugarEntry = bloodSugarEntry;
//    }
//
//    public String getEntry() {
//        return Entry;
//    }
//
//    public void setEntry(String entry) {
//        Entry = entry;
//    }
//
//    public Integer getBloodSugarEntry() {
//        return bloodSugarEntry;
//    }
//
//    public void setBloodSugarEntry(Integer bloodSugarEntry) {
//        this.bloodSugarEntry = bloodSugarEntry;
//    }
}
