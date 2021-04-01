package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

//        var dl = new DataLibrary();
//        var recipes = dl.load();
//        for(Recipe recipe : recipes){
//            System.out.println(recipe);
//        }

        var dm = new DatabaseManager();
        dm.loadCSV();
    }
}