package com.kitchen.frontend.cocktail;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.List;


public class CocktailList {
    @JsonProperty("drinks")
    List<Cocktail> cocktails;

    public List<Cocktail> getCocktails() {
        return cocktails;
    }
}
