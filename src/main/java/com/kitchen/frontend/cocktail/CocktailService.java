package com.kitchen.frontend.cocktail;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CocktailService {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/";

    public CocktailService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Cocktail fetchRandomCocktail() {
        CocktailList cocktail = restTemplate.getForObject(BASE_URL + "random.php", CocktailList.class);
        return cocktail.getCocktails().get(0);
    }
}
