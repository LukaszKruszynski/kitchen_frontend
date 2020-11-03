package com.kitchen.frontend;

import com.kitchen.frontend.meal.Meal;
import com.kitchen.frontend.meal.MealList;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Route("meals")
@SpringComponent
public class RandomMealView extends VerticalLayout {

    private final RestTemplate restTemplate;
    private Grid<Meal> grid = new Grid();

    public RandomMealView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        grid.addColumn(Meal::getStrInstructions);
        grid.addColumn(Meal::getStrMeal);
        grid.addColumn(Meal::getIdMeal);
        grid.addColumn(Meal::getStrArea);
        grid.addColumn(Meal::getStrCategory);
        grid.addColumn(Meal::getStrMealThumb);
        grid.setItems(fetchRandomMeal().getMeals().get(0));
        add(grid);
    }

    private MealList fetchRandomMeal() {
        ResponseEntity<MealList> meals = restTemplate.getForEntity("http://localhost:9090/v1/meals/random", MealList.class);
        return meals.getBody();
    }
}
