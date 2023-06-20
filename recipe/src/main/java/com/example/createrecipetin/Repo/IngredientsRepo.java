package com.example.createrecipetin.Repo;


import com.example.createrecipetin.Entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepo extends JpaRepository<Ingredients, Long> {
}
