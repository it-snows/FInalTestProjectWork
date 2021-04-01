package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {
    private int ingredientId;
    private Recipe recipe;
    private String ingredient;

     public Ingredient() {
    }

    public Ingredient(int ingredientId, Recipe recipe, String ingredient) {
        this.ingredientId = ingredientId;
        this.recipe = recipe;
        this.ingredient = ingredient;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}
