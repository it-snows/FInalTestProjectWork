package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataLibrary {

    public static final String FILE_PATH = "src/main/java/com/company/desserts.json";

    public List<Recipe> load() {
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
        return null;
    }










//    public Recipe load() {
//        ObjectMapper mapper = new ObjectMapper();
//
//
////        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
//        try {
//
//           List <Recipe> recipes = mapper.reader().forType(new TypeReference<>(){}).readValue(new File(FILE_PATH));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
