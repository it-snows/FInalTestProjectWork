package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        var dl = new DataLibrary();
        var recipes = dl.load();

        for(Recipe recipe : recipes){
            System.out.println(recipe);
        }

    }
}
