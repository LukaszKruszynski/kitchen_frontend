package com.kitchen.frontend.meal;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";

    public MealService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public Meal fetchRandomMeal() {
        MealList meal = restTemplate.getForObject(BASE_URL + "random.php", MealList.class);
        return meal.getMeals().get(0);
    }
}
