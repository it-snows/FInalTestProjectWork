package com.company;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseManager {

    private static final String connectionUrl = "jdbc:mysql://localhost:3306/recipes?serverTimezone=UTC";
    private static final String FILE_PATH = "src/main/java/com/company/desserts.json";


    public List<Recipe> readRecipe() {
        List<Recipe> recipes = new ArrayList<>();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);
            var data = fis.readAllBytes();
            var json = new String(data);
            Gson gson = new Gson();
            Type collectionType = new TypeToken<List<Recipe>>() {
            }.getType();
            return gson.fromJson(json, collectionType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return recipes;
    }

    public void loadCSVRecipes() throws SQLException {
        var con = getConnection();

        var recipes = readRecipe();
        String sqlStatement = "INSERT INTO recipes (recipe_title, course, total_time, number_of_servings," +
                "instructions, picture_link) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = con.prepareStatement(sqlStatement);

        for (Recipe recipe : recipes) {
            statement.setString(1, recipe.getTitle());
            statement.setString(2, recipe.getCourse());
            statement.setInt(3, recipe.getTotalTime());
            statement.setInt(4, recipe.getNumberOfServings());
            statement.setString(5, recipe.getInstructions());
            statement.setString(6, recipe.getPictureLink());
            statement.executeUpdate();
        }
    }

    public void loadCSVIngredients() throws SQLException {
        var con = getConnection();

        var ingredients = readRecipe();
        String sqlStatement = "INSERT INTO ingredients (recipe_id, ingredient) values (?,?)";
        PreparedStatement statement = con.prepareStatement(sqlStatement);

        for (Recipe ingredient : ingredients) {
            statement.setInt(1, ingredient.getRecipeId());
            statement.setString(2, Arrays.toString(ingredient.getIngredients()));
            statement.executeUpdate();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, "test", "test123");
    }
}
