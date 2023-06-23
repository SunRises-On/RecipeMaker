package com.example.createrecipetin.repositories;

import com.example.createrecipetin.models.Ingredients;
import com.example.createrecipetin.models.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionsRepo extends JpaRepository<Instructions,Long> {
    Instructions getByRecipeId(Long recipe_id);

}
