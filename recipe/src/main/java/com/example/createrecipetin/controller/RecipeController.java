package com.example.createrecipetin.controller;


import com.example.createrecipetin.models.Ingredients;
import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import com.example.createrecipetin.service.RecipeService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpHeaders;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;


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
    //@ResponseBody annotation tells a controller that the object
    //returned is automatically serialized into JSON and passed
    // back into the HttpResponse object
    //@ResponseBody
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) throws ServerException {

        Recipe recipe = recipeService.save(newRecipe);
        if(recipe == null){
            throw new ServerException("Error creating new recipe.");
        } else{
            return new ResponseEntity(recipe, HttpStatus.CREATED);
        }
    }

    @GetMapping(path ="/all")
    public ResponseEntity <List<Recipe>> getAllRecipes(){
        System.out.println("----------------------------------------");
        List<Recipe> r = recipeRepo.findAll();
        r.forEach( re -> {
            System.out.println(re);
        });
        //This returns a JSOn with the users
    //    List<Recipe> r= recipeRepo.findAll();
     //   for(Recipe recipe: r){
     //       Long id = recipe.getId();
     //       int i = id.intValue();
     //       System.out.println( i);
     //       Ingredients ing = ingredientsRepo.getByRecipeId(recipe.getId());
      //      System.out.println(recipe);
      //  }
        return new ResponseEntity(r, HttpStatus.OK);
    }

    @GetMapping (path ="/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id){
        System.out.println("id = " + id);
        //findById is eager loaded so it will immediately populate the entity
        //getReferenceById was crashing the program when I tried to convert it to ResponseEntity
        Optional<Recipe> r = recipeRepo.findById(id);
        System.out.println(r);
        return new ResponseEntity(r, HttpStatus.OK);
    }
}
