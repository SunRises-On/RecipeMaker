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
import org.springframework.http.converter.HttpMessageNotReadableException;
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
        List<Recipe> r = recipeService.findAll();
        r.forEach( re -> {
            System.out.println(re);
        });
        return new ResponseEntity(r, HttpStatus.OK);
    }

    @GetMapping (path ="/{id}")
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id){
        System.out.println("id = " + id);
        //findById is eager loaded so it will immediately populate the entity
        //getReferenceById was crashing the program when I tried to convert it to ResponseEntity
        Optional<Recipe> r = recipeService.getById(id);//recipeRepo.findById(id);
        System.out.println(r);
        if(r.isEmpty()){

            throw new IllegalArgumentException("Error getting Recipe by id.");
        } else{
            return new ResponseEntity(r, HttpStatus.CREATED);
        }

    }

    @PutMapping(path="/{id}")
    public Recipe replaceRecipe(@RequestBody Recipe newRecipe,
                                                @PathVariable Long id){
        return recipeService.getById(id)
                .map(recipe -> {
                    recipe.setIngredient(newRecipe.getIngredient());
                    recipe.setInstruction(newRecipe.getInstruction());
                    return recipeService.save(recipe);
                })
                .orElseGet(()->{
                    newRecipe.setId(id);
                    return recipeService.save(newRecipe);
                });
    }

    @DeleteMapping(path="/{id}")
    void deleteEmployee(@PathVariable Long id){
        Optional<Recipe> recipe = recipeService.getById(id);
        System.out.println(recipe);
        if(recipe.isEmpty()){
            throw new IllegalArgumentException("Error Recipe not found by id.");
        } else{
            recipeService.deleteById(id);
        }
    }

    @DeleteMapping(path="/all")
    void deleteEmployees(){
        recipeService.deleteAll();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleIllegalArgumentException(
            IllegalArgumentException exception
    ){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException httpMessageNotReadableException
    ){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Malformed JSON request");
    }
}
