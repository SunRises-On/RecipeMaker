package com.example.recipe.Repo;


import com.example.recipe.Entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {
}
