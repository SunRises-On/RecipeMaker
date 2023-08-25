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
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe newRecipe) throws ServerException {

        Recipe recipe = recipeService.save(newRecipe);
        System.out.println(recipe);
        if(recipe == null){
            throw new ServerException("Error creating new recipe.");
        } else{
            ResponseEntity response= ResponseEntity.status(HttpStatus.CREATED).body(recipe);

            return response;
        }
    }

    @GetMapping(value ="/all",
            produces = "application/json"
    )
    //produces condition ensures that the actual content type used to
    //generate the response respsects the media types specified
    //in the produces condition
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Recipe>> getAllRecipes(){
        System.out.println("----------------------------------------");
        List<Recipe> recipeList = recipeService.findAll();
        recipeList.forEach( re -> {
            System.out.println(re);
        });
        ResponseEntity response= ResponseEntity.status(HttpStatus.OK).body(recipeList);

        return response;
    }

    @GetMapping (path ="/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id){
        System.out.println("id = " + id);
        //findById is eager loaded so it will immediately populate the entity
        //getReferenceById was crashing the program when I tried to convert it to ResponseEntity
        Optional<Recipe> r = recipeService.getById(id);
        System.out.println(r);
        if(r.isEmpty()){

            throw new IllegalArgumentException("Error getting Recipe by id.");
        } else{
            return new ResponseEntity(r, HttpStatus.CREATED);
        }

    }

    @PutMapping(path="/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public  ResponseEntity<Recipe> replaceRecipe(@RequestBody Recipe newRecipe,
                                                @PathVariable Long id){
        //If empty create new object with HTTP code 201 (created)
        if(recipeService.getById(id).isEmpty()){
            Recipe recipe = recipeService.save(newRecipe);
            ResponseEntity response= ResponseEntity.status(HttpStatus.CREATED).body(recipe);
            return response;
            //Update recipe return HTTP code 200 (ok)
        }else{
            Optional<Recipe> recipe = recipeService.update(newRecipe, id);
            ResponseEntity response = ResponseEntity.status(HttpStatus.OK).body(recipe);
            return response;
        }
    }

    @DeleteMapping(path="/{id}")
    void deleteEmployee(@PathVariable Long id) throws Exception {
        //Optional returns empty if null
        Optional<Recipe> recipe = recipeService.getById(id);
        System.out.println(recipe);
        if(recipe.isEmpty()){
            throw new IllegalArgumentException("Error Recipe not found by id.");
        } else{
            recipeService.deleteById(id);
        }
    }

    @DeleteMapping(path="/all")
    void deleteEmployees() throws Exception {
        recipeService.deleteAll();
    }

    /***
     * Exceptional Handling
     */


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
