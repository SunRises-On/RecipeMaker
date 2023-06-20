package com.example.createrecipetin.Controller;


import com.example.createrecipetin.Entity.Directions;
import com.example.createrecipetin.Entity.Ingredients;
import com.example.createrecipetin.Entity.Recipe;
import com.example.createrecipetin.Repo.DirectionsRepo;
import com.example.createrecipetin.Repo.IngredientsRepo;
import com.example.createrecipetin.Repo.RecipeRepo;
import com.example.createrecipetin.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private DirectionsRepo directionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;


    @PostMapping(value="/upload",
        consumes= "application/json",
        produces= "application/json"
    )
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) throws ServerException {
        System.out.println(newRecipe.toString());
        Recipe recipe = recipeService.save(newRecipe);
        if(recipe == null){
            throw new ServerException("Error creating new recipe.");
        } else{
            return new ResponseEntity(recipe, HttpStatus.CREATED);
        }
    }
}
