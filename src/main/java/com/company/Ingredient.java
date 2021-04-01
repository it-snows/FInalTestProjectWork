package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {
    private int ingredientId;
    private int recipeId;
    private String ingredient;

    public Ingredient(int ingredientId, int recipeId, String ingredient) {
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
        this.ingredient = ingredient;
    }

    public Ingredient() {
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
