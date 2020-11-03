package com.kitchen.frontend.cocktail;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CocktailList {
    @JsonProperty("drinks")
    List<Cocktail> cocktails;
}
