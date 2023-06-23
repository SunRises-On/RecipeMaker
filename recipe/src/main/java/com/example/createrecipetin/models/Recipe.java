package com.example.createrecipetin.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode

@Entity
@Table(name="recipe")
public class Recipe implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    //whoever owns the foreign key column gets the @Join Column
    // annotation
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY,
            cascade=CascadeType.ALL,
            mappedBy="recipe"
    )
    private Instructions instruction;


    @JsonManagedReference
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

    public Instructions getInstruction() {
        return instruction;
    }

    public void setInstruction(Instructions instruction) {
        this.instruction = instruction;
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
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", instruction=" + getInstruction() +
                ", ingredient=" + getIngredient() +
                '}';
    }
}
