package com.example.recipe.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy="recipe")
    private Recipe recipe;

    @Column(name="ingredient_1")
    private String ingredient_1;

    @Column(name="ingredient_2")
    private String ingredient_2;

    @Column(name="ingredient_3")
    private String ingredient_3;

    @Column(name="ingredient_4")
    private String ingredient_4;

    @Column(name="ingredient_5")
    private String ingredient_5;

    @Column(name="ingredient_6")
    private String ingredient_6;

    @Column(name="ingredient_7")
    private String ingredient_7;

    @Column(name="ingredient_8")
    private String ingredient_8;

    @Column(name="ingredient_9")
    private String ingredient_9;

    @Column(name="ingredient_10")
    private String ingredient_10;

    @Column(name="ingredient_11")
    private String ingredient_11;

    @Column(name="ingredient_12")
    private String ingredient_12;

    @Column(name="ingredient_13")
    private String ingredient_13;

    @Column(name="ingredient_14")
    private String ingredient_14;

    @Column(name="ingredient_15")
    private String ingredient_15;

    @Column(name="ingredient_16")
    private String ingredient_16;

    @Column(name="ingredient_17")
    private String ingredient_17;

    @Column(name="ingredient_18")
    private String ingredient_18;

    @Column(name="ingredient_19")
    private String ingredient_19;

    @Column(name="ingredient_20")
    private String ingredient_20;

    @Column(name="ingredient_21")
    private String ingredient_21;

    @Column(name="ingredient_22")
    private String ingredient_22;

    @Column(name="ingredient_23")
    private String ingredient_23;

    @Column(name="ingredient_24")
    private String ingredient_24;

    @Column(name="ingredient_25")
    private String ingredient_25;

    @Column(name="ingredient_26")
    private String ingredient_26;

    @Column(name="ingredient_27")
    private String ingredient_27;

    @Column(name="ingredient_28")
    private String ingredient_28;

    @Column(name="ingredient_29")
    private String ingredient_29;

    @Column(name="ingredient_30")
    private String ingredient_30;

    @Column(name="ingredient_31")
    private String ingredient_31;

    @Column(name="ingredient_32")
    private String ingredient_32;

    @Column(name="ingredient_33")
    private String ingredient_33;

    @Column(name="ingredient_34")
    private String ingredient_34;

    @Column(name="ingredient_35")
    private String ingredient_35;

    @Column(name="ingredient_36")
    private String ingredient_36;

    @Column(name="ingredient_37")
    private String ingredient_37;

    @Column(name="ingredient_38")
    private String ingredient_38;

    @Column(name="ingredient_39")
    private String ingredient_39;

    @Column(name="ingredient_40")
    private String ingredient_40;

    @Column(name="ingredient_41")
    private String ingredient_41;

    @Column(name="ingredient_42")
    private String ingredient_42;

    @Column(name="ingredient_43")
    private String ingredient_43;

    @Column(name="ingredient_44")
    private String ingredient_44;

    @Column(name="ingredient_45")
    private String ingredient_45;

    @Column(name="ingredient_46")
    private String ingredient_46;

    @Column(name="ingredient_47")
    private String ingredient_47;

    @Column(name="ingredient_48")
    private String ingredient_48;

    @Column(name="ingredient_49")
    private String ingredient_49;

    @Column(name="ingredient_50")
    private String ingredient_50;


}
