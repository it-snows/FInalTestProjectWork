package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {
    private int recipeId;
    private String title;
    private String course;
    private int totalTime;
    private int numberOfServings;



    private String[] ingredients;
    private String instructions;
    private String pictureLink;

       public Recipe() {
    }

    public Recipe(int recipeId, String title, String course, int totalTime, int numberOfServings, String[] ingredients, String instructions, String pictureLink) {
        this.recipeId = recipeId;
        this.title = title;
        this.course = course;
        this.totalTime = totalTime;
        this.numberOfServings = numberOfServings;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.pictureLink = pictureLink;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }



    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", title='" + title + '\'' +
                ", course='" + course + '\'' +
                ", totalTime=" + totalTime +
                ", numberOfServings=" + numberOfServings +
                ", ingredients=" + Arrays.toString(ingredients) +
                ", instructions='" + instructions + '\'' +
                ", pictureLink='" + pictureLink + '\'' +
                '}';
    }
}
