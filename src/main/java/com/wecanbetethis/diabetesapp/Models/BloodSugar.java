package com.wecanbetethis.diabetesapp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BloodSugar {

    @Id
    @GeneratedValue
    private int id;

}
