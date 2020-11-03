package com.kitchen.frontend.meal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MealList {
    @JsonProperty("meals")
    List<Meal> meals;

    public List<Meal> getMeals() {
        return meals;
    }
}
