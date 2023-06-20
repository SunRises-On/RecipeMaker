package com.example.recipe.Service;


import com.example.recipe.Entity.Recipe;
import com.example.recipe.Repo.DirectionsRepo;
import com.example.recipe.Repo.IngredientsRepo;
import com.example.recipe.Repo.RecipeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
