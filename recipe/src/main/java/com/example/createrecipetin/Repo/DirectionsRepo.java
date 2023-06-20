package com.example.createrecipetin.Repo;

import com.example.createrecipetin.Entity.Directions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionsRepo extends JpaRepository<Directions,Long> {
}
