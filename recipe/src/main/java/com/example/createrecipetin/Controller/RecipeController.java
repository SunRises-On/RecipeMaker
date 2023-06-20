package com.example.recipe.Controller;


import com.example.recipe.Entity.Directions;
import com.example.recipe.Entity.Ingredients;
import com.example.recipe.Entity.Recipe;
import com.example.recipe.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;


@CrossOrigin(value="http://localhost:3000")
@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    private Recipe recipeRepo;
    @Autowired
    private Directions directionsRepo;
    @Autowired
    private Ingredients ingredientsRepo;


    @PostMapping(value="/upload",
        consumes= MediaType.APPLICATION_JSON_VALUE,
        produces= MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createRecipe(@RequestBody Recipe newRecipe) throws ServerException {
        System.out.println(newRecipe);

        Recipe recipe = recipeService.save(newRecipe);
        if(recipe == null){
            throw new ServerException("Error creating new recipe.");
        } else{
            return new ResponseEntity(recipe, HttpStatus.CREATED);
        }
    }
}
