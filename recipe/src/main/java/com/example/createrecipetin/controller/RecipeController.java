package com.example.createrecipetin.controller;


import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import com.example.createrecipetin.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private InstructionsRepo instructionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;


    @PostMapping(value="/upload",
        consumes= "application/json",
        produces= "application/json"
    )
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) throws ServerException {
        System.out.println(newRecipe.toString());
        System.out.println("in create recipe");
        Recipe recipe = recipeService.save(newRecipe);

        if(recipe == null){
            throw new ServerException("Error creating new recipe.");
        } else{
            return new ResponseEntity(recipe, HttpStatus.CREATED);
        }
    }
}
