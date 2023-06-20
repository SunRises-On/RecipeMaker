package com.example.recipe.Repo;

import com.example.recipe.Entity.Directions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionsRepo extends JpaRepository<Directions,Long> {
}
