package com.example.createrecipetin.repositories;


import com.example.createrecipetin.models.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {

    Ingredients getByRecipeId(Long recipe_id);
}
