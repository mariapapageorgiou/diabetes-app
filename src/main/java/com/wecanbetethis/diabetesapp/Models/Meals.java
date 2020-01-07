package com.wecanbetethis.diabetesapp.Models;

public enum Meals {
    FASTING_ENTRY("Fasting"),
    BREAKFAST_ENTRY("Breakfast"),
    MORNING_SNACK_ENTRY("Morning Snack"),
    LUNCH_ENTRY("Lunch"),
    AFTERNOON_SNACK_ENTRY("Afternoon Snack"),
    DINNER_ENTRY("Dinner"),
    EVENING_SNACK_ENTRY("Evening Snack");

    private final String name;

    private Meals(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
