package com.example.createrecipetin.service;


import com.example.createrecipetin.models.Ingredients;
import com.example.createrecipetin.models.Instructions;
import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InstructionService {

    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private InstructionsRepo instructionsRepo;
    @Autowired
    private IngredientsRepo ingredientsRepo;

    public Instructions saveRecipe (Recipe recipe){
        Instructions instructions = recipe.getInstruction();
        instructions.setRecipe(recipe);

        return instructions;
    }

}
