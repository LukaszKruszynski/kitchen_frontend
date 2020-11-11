package com.kitchen.frontend.product;

import com.kitchen.frontend.cocktail.CocktailService;
import com.kitchen.frontend.meal.MealService;
import com.vaadin.flow.component.html.Anchor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LinkComponent {

    private String randomMealSource;
    private static final String MEAL_TEXT = "Get random meal";
    private static final String COCKTAIL_TEXT = "Get random cocktail";
    @Autowired
    private MealService mealService;
    @Autowired
    private CocktailService cocktailService;
    private Anchor linkMeal = new Anchor();
    private Anchor linkCocktail = new Anchor();

    public Anchor createLinkMeal() {
        linkMeal.setText(MEAL_TEXT);
        linkMeal.setHref(mealService.fetchRandomMeal().getStrSource());
        return linkMeal;
    }

    public Anchor createLinkCocktail() {
        String nameDrink = cocktailService.fetchRandomCocktail().getStrDrink();
        linkCocktail.setText(COCKTAIL_TEXT);
        linkCocktail.setHref("https://www.google.com/search?q=" + nameDrink + " drink" + "&num=10");
        return linkCocktail;
    }
}
