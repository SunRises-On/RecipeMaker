package com.example.createrecipetin.Service;


import com.example.createrecipetin.Entity.Recipe;
import com.example.createrecipetin.Repo.DirectionsRepo;
import com.example.createrecipetin.Repo.IngredientsRepo;
import com.example.createrecipetin.Repo.RecipeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private DirectionsRepo directionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;

    public Recipe save(Recipe recipe){
        //recipeRepo.save(recipe);
        Recipe newRecipe = recipeRepo.save(recipe);
        return newRecipe;
    }

    public Iterable<Recipe> list(){
        return recipeRepo.findAll();
    }

    public Iterable<Recipe> saveAll(List<Recipe> recipes){
        return recipeRepo.saveAll(recipes);
    }
}
