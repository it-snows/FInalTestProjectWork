package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public void loadCSV() throws SQLException {
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
//    public void addIngredients(List<Ingredient> ingredients) {
//        Connection con = null;
//        try {
//            con = getConnection();
//            for (Ingredient ingredient : ingredients) {
//                var insertIngredients = con.prepareStatement(
//                        "insert into ingredients (recipe_id, ingredient) values (?, ?)");
//
//
//                insertIngredients.setInt(1, ingredient.getRecipe().getRecipeId());
//                insertIngredients.setString(2, ingredient.getIngredient());
//
//                insertIngredients.executeUpdate();
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public void addRecipes(List<Recipe> recipes) {
//        Connection con = null;
//        try {
//            con = getConnection();
//            for (Recipe recipe : recipes) {
//                var insertRecipes = con.prepareStatement(
//                        "insert into recipes (recipe_title, course, total_time, number_of_servings," +
//                                "instructions, picture_link) values (?, ?, ?, ?, ?, ?)",
//                        Statement.RETURN_GENERATED_KEYS);
//
//                insertRecipes.setString(1, recipe.getTitle());
//                insertRecipes.setString(2, recipe.getCourse());
//
//                if (recipe.getTotalTime() != 0) {
//                    insertRecipes.setInt(3, recipe.getTotalTime());
//                } else {
//                    insertRecipes.setNull(3, java.sql.Types.INTEGER);
//                }
//                insertRecipes.setInt(4, recipe.getNumberOfServings());
//                insertRecipes.setString(5, recipe.getInstructions());
//                insertRecipes.setString(6, recipe.getPictureLink());
//
//                insertRecipes.executeUpdate();
//
//
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, "test", "test123");
    }
}
