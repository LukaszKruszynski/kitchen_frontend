package com.kitchen.frontend.cocktail;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "idDrink",
        "strDrink",
        "strDrinkAlternate",
        "strDrinkES",
        "strDrinkDE",
        "strDrinkFR",
        "strDrinkZH-HANS",
        "strDrinkZH-HANT",
        "strTags",
        "strVideo",
        "strCategory",
        "strIBA",
        "strAlcoholic",
        "strGlass",
        "strInstructions",
        "strInstructionsES",
        "strInstructionsDE",
        "strInstructionsFR",
        "strInstructionsZH-HANS",
        "strInstructionsZH-HANT",
        "strDrinkThumb",
        "strIngredient1",
        "strIngredient2",
        "strIngredient3",
        "strIngredient4",
        "strIngredient5",
        "strIngredient6",
        "strIngredient7",
        "strIngredient8",
        "strIngredient9",
        "strIngredient10",
        "strIngredient11",
        "strIngredient12",
        "strIngredient13",
        "strIngredient14",
        "strIngredient15",
        "strMeasure1",
        "strMeasure2",
        "strMeasure3",
        "strMeasure4",
        "strMeasure5",
        "strMeasure6",
        "strMeasure7",
        "strMeasure8",
        "strMeasure9",
        "strMeasure10",
        "strMeasure11",
        "strMeasure12",
        "strMeasure13",
        "strMeasure14",
        "strMeasure15",
        "strCreativeCommonsConfirmed",
        "dateModified"
})
public class Cocktail {

    @JsonProperty("idDrink")
    public String idDrink;
    @JsonProperty("strDrink")
    public String strDrink;
    @JsonProperty("strDrinkAlternate")
    public String strDrinkAlternate;
    @JsonProperty("strDrinkES")
    public String strDrinkES;
    @JsonProperty("strDrinkDE")
    public String strDrinkDE;
    @JsonProperty("strDrinkFR")
    public String strDrinkFR;
    @JsonProperty("strDrinkZH-HANS")
    public String strDrinkZHHANS;
    @JsonProperty("strDrinkZH-HANT")
    public String strDrinkZHHANT;
    @JsonProperty("strTags")
    public String strTags;
    @JsonProperty("strVideo")
    public String strVideo;
    @JsonProperty("strCategory")
    public String strCategory;
    @JsonProperty("strIBA")
    public String strIBA;
    @JsonProperty("strAlcoholic")
    public String strAlcoholic;
    @JsonProperty("strGlass")
    public String strGlass;
    @JsonProperty("strInstructions")
    public String strInstructions;
    @JsonProperty("strInstructionsES")
    public String strInstructionsES;
    @JsonProperty("strInstructionsDE")
    public String strInstructionsDE;
    @JsonProperty("strInstructionsFR")
    public String strInstructionsFR;
    @JsonProperty("strInstructionsZH-HANS")
    public String strInstructionsZHHANS;
    @JsonProperty("strInstructionsZH-HANT")
    public String strInstructionsZHHANT;
    @JsonProperty("strDrinkThumb")
    public String strDrinkThumb;
    @JsonProperty("strIngredient1")
    public String strIngredient1;
    @JsonProperty("strIngredient2")
    public String strIngredient2;
    @JsonProperty("strIngredient3")
    public String strIngredient3;
    @JsonProperty("strIngredient4")
    public String strIngredient4;
    @JsonProperty("strIngredient5")
    public String strIngredient5;
    @JsonProperty("strIngredient6")
    public String strIngredient6;
    @JsonProperty("strIngredient7")
    public String strIngredient7;
    @JsonProperty("strIngredient8")
    public String strIngredient8;
    @JsonProperty("strIngredient9")
    public String strIngredient9;
    @JsonProperty("strIngredient10")
    public String strIngredient10;
    @JsonProperty("strIngredient11")
    public String strIngredient11;
    @JsonProperty("strIngredient12")
    public String strIngredient12;
    @JsonProperty("strIngredient13")
    public String strIngredient13;
    @JsonProperty("strIngredient14")
    public String strIngredient14;
    @JsonProperty("strIngredient15")
    public String strIngredient15;
    @JsonProperty("strMeasure1")
    public String strMeasure1;
    @JsonProperty("strMeasure2")
    public String strMeasure2;
    @JsonProperty("strMeasure3")
    public String strMeasure3;
    @JsonProperty("strMeasure4")
    public String strMeasure4;
    @JsonProperty("strMeasure5")
    public String strMeasure5;
    @JsonProperty("strMeasure6")
    public String strMeasure6;
    @JsonProperty("strMeasure7")
    public String strMeasure7;
    @JsonProperty("strMeasure8")
    public String strMeasure8;
    @JsonProperty("strMeasure9")
    public String strMeasure9;
    @JsonProperty("strMeasure10")
    public String strMeasure10;
    @JsonProperty("strMeasure11")
    public String strMeasure11;
    @JsonProperty("strMeasure12")
    public String strMeasure12;
    @JsonProperty("strMeasure13")
    public String strMeasure13;
    @JsonProperty("strMeasure14")
    public String strMeasure14;
    @JsonProperty("strMeasure15")
    public String strMeasure15;
    @JsonProperty("strCreativeCommonsConfirmed")
    public String strCreativeCommonsConfirmed;
    @JsonProperty("dateModified")
    public String dateModified;

    public String getIdDrink() {
        return idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public String getStrDrinkES() {
        return strDrinkES;
    }

    public String getStrDrinkDE() {
        return strDrinkDE;
    }

    public String getStrDrinkFR() {
        return strDrinkFR;
    }

    public String getStrDrinkZHHANS() {
        return strDrinkZHHANS;
    }

    public String getStrDrinkZHHANT() {
        return strDrinkZHHANT;
    }

    public String getStrTags() {
        return strTags;
    }

    public String getStrVideo() {
        return strVideo;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrIBA() {
        return strIBA;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getStrInstructionsES() {
        return strInstructionsES;
    }

    public String getStrInstructionsDE() {
        return strInstructionsDE;
    }

    public String getStrInstructionsFR() {
        return strInstructionsFR;
    }

    public String getStrInstructionsZHHANS() {
        return strInstructionsZHHANS;
    }

    public String getStrInstructionsZHHANT() {
        return strInstructionsZHHANT;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrIngredient4() {
        return strIngredient4;
    }

    public String getStrIngredient5() {
        return strIngredient5;
    }

    public String getStrIngredient6() {
        return strIngredient6;
    }

    public String getStrIngredient7() {
        return strIngredient7;
    }

    public String getStrIngredient8() {
        return strIngredient8;
    }

    public String getStrIngredient9() {
        return strIngredient9;
    }

    public String getStrIngredient10() {
        return strIngredient10;
    }

    public String getStrIngredient11() {
        return strIngredient11;
    }

    public String getStrIngredient12() {
        return strIngredient12;
    }

    public String getStrIngredient13() {
        return strIngredient13;
    }

    public String getStrIngredient14() {
        return strIngredient14;
    }

    public String getStrIngredient15() {
        return strIngredient15;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public String getStrMeasure4() {
        return strMeasure4;
    }

    public String getStrMeasure5() {
        return strMeasure5;
    }

    public String getStrMeasure6() {
        return strMeasure6;
    }

    public String getStrMeasure7() {
        return strMeasure7;
    }

    public String getStrMeasure8() {
        return strMeasure8;
    }

    public String getStrMeasure9() {
        return strMeasure9;
    }

    public String getStrMeasure10() {
        return strMeasure10;
    }

    public String getStrMeasure11() {
        return strMeasure11;
    }

    public String getStrMeasure12() {
        return strMeasure12;
    }

    public String getStrMeasure13() {
        return strMeasure13;
    }

    public String getStrMeasure14() {
        return strMeasure14;
    }

    public String getStrMeasure15() {
        return strMeasure15;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }
}
