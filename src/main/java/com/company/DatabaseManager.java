package com.company;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void loadIngredients(List<Integer> ids) throws SQLException, IOException {
        var con = getConnection();
        var recipes = readRecipe();
        String sqlStatement = "INSERT INTO ingredients (recipe_id, ingredients) values (?, ?)";
        PreparedStatement statement = con.prepareStatement(sqlStatement);

        Path path = Paths.get(FILE_PATH);
        var lines = Files.readAllLines(path);
        for (Recipe recipe : recipes) {
            for (int i = 1; i < lines.size(); i++) {
                Integer recipeId = ids.get(i - 1);
                statement.setInt(1, recipe.getRecipeId());
            }
                statement.setString(2, Arrays.toString(recipe.getIngredients()));
                statement.executeUpdate();
            }
        }


    public List<Integer> getRecipeIdFromDB() {             //needed for recipe_id
        List<Integer> ids = new ArrayList<>();
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select recipe_id from recipes");
            while (rs.next()) {
                Integer id = rs.getInt("recipe_id");
                ids.add(id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ids;
    }

//    public void loadIngredients() throws SQLException {
//        var con = getConnection();
//
//        var ingredients = readRecipe();
//        String sqlStatement = "INSERT INTO ingredients (recipe_id, ingredient) values (?,?)";
//        PreparedStatement statement = con.prepareStatement(sqlStatement);
//
//        for (Recipe ingredient : ingredients) {
//            statement.setInt(1, ingredient.getRecipeId());
//            statement.setString(2, Arrays.toString(ingredient.getIngredients()));
//            statement.executeUpdate();
//        }
//    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, "test", "test123");
    }
}
