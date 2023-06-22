package com.example.createrecipetin.models;

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
    private Instructions instruction;

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
                "id=" + id +
                ", name='" + name + '\'' +
                ", instruction=" + instruction +
                ", ingredient=" + ingredient +
                '}';
    }
}
