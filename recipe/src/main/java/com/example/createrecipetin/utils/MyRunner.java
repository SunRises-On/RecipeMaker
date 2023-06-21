package com.example.createrecipetin.utils;

import com.example.createrecipetin.Entity.Recipe;
import com.example.createrecipetin.Repo.DirectionsRepo;
import com.example.createrecipetin.Repo.IngredientsRepo;
import com.example.createrecipetin.Repo.RecipeRepo;
import com.example.createrecipetin.Service.RecipeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;


/***
 * Coommand-line runners are a useful functionality to execute the various
 * types of code that only have to be rune once, right after application startup.
 */
@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private DirectionsRepo directionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;
    @Autowired
    private RecipeService recipeService;
    @Override
    public void run(String...args) throws Exception{
        System.out.println("ApplicationRunner called");
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Recipe>> typeReference = new TypeReference<List<Recipe>>(){};
        try{
            for(int i = 0 ; i< 6; i++){
                String filename = "recipe_" + (i+1);
                InputStream inputStream = TypeReference.class.getResourceAsStream()
            }

        }catch(IOException e){
            System.out.println("Unable to save recipes: " + e.getMessage());
        }


    }
}
