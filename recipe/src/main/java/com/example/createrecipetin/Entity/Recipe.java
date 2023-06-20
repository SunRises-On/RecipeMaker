package com.example.createrecipetin.Entity;

import com.example.createrecipetin.Entity.Ingredients;
import jakarta.persistence.*;


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
    @OneToOne(fetch = FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy="recipe"
    )
    private Directions direction;

    @OneToOne( fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "recipe"
    )
    private Ingredients ingredient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", direction=" + direction +
                ", ingredient=" + ingredient +
                '}';
    }
}
