package com.example.recipe.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    //whoever owns the foreign key column gets the @Join Column
    // annotation
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name= "directions_id", referencedColumnName = "id")
    private Directions direction;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ingredients_id", referencedColumnName = "id")
    private Ingredients ingredient;
}
