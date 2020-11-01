package com.kitchen.frontend;

import com.kitchen.frontend.config.CoreConfiguration;
import com.kitchen.frontend.meal.Meal;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Route(value = "/meals/random")
public class RandomMealView extends VerticalLayout {
    @Autowired
    private RestTemplate restTemplate;
    private Grid<Meal> grid = new Grid<>();
    public RandomMealView() {
//    grid.setItems(fetchRandomMeal());
    add(grid);
    }
    private Meal fetchRandomMeal() {
        return restTemplate.getForObject("http://localhost:9090/v1/meals/random",Meal.class);
    }
}
