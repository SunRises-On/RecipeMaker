package com.example.createrecipetin.utils;

import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import com.example.createrecipetin.service.RecipeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


/***
 * Coommand-line runners are a useful functionality to execute the various
 * types of code that only have to be rune once, right after application startup.
 */

public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private InstructionsRepo instructionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;
    @Autowired
    private RecipeService recipeService;
    @Override
    public void run(String...args) throws Exception{
        System.out.println("ApplicationRunner called");
        //part of the Jackson API
        //ObjectMapper is used to parse or deserialize (byte stream is used to recreate the actual Java object in memory)
        //JSON content into a Java object
        ObjectMapper mapper = new ObjectMapper();
        //
        TypeReference<Recipe> typeReference = new TypeReference<Recipe>(){};
        try{
            for(int i = 0 ; i< 6; i++){
                String fileName = "recipe_" + (i+1);
                System.out.println("recipe name = "+ fileName);
                String filePath = "json/" + fileName + ".json";

                //InputStream class of the java.io packages is an
                //abstract superclass that represents an input stream of bytes
                InputStream inputStream = TypeReference.class.getResourceAsStream("/json/"+fileName+".json");


                Recipe recipe = mapper.readValue(inputStream, typeReference);
                recipeService.save(recipe);
            }

        }catch(IOException e){
            System.out.println("Unable to save recipes: " + e.getMessage());
        }

        logger.info("The number of recipes: {}", recipeRepo.count());
        logger.info("All recipes unsorted:");

        Iterable <Recipe> recipes = recipeRepo.findAll();
        Iterator<Recipe> iterator = recipes.iterator();
        while (iterator.hasNext()) {
            logger.info("{}", iterator.next().toString());
        }

        logger.info("--------------------------------");


    }
}
