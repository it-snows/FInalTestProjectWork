package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.util.Arrays;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


}