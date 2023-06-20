package com.example.recipe.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="directions")
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy="recipe")
    private Recipe recipe;

    @Column(name="direction_1")
    private String direction_1;

    @Column(name="direction_2")
    private String direction_2;

    @Column(name="direction_3")
    private String direction_3;

    @Column(name="direction_4")
    private String direction_4;

    @Column(name="direction_5")
    private String direction_5;

    @Column(name="direction_6")
    private String direction_6;

    @Column(name="direction_7")
    private String direction_7;

    @Column(name="direction_8")
    private String direction_8;

    @Column(name="direction_9")
    private String direction_9;

    @Column(name="direction_10")
    private String direction_10;

    @Column(name="direction_11")
    private String direction_11;

    @Column(name="direction_12")
    private String direction_12;

    @Column(name="direction_13")
    private String direction_13;

    @Column(name="direction_14")
    private String direction_14;

    @Column(name="direction_15")
    private String direction_15;

    @Column(name="direction_16")
    private String direction_16;

    @Column(name="direction_17")
    private String direction_17;

    @Column(name="direction_18")
    private String direction_18;

    @Column(name="direction_19")
    private String direction_19;

    @Column(name="direction_20")
    private String direction_20;

    @Column(name="direction_21")
    private String direction_21;

    @Column(name="direction_22")
    private String direction_22;

    @Column(name="direction_23")
    private String direction_23;

    @Column(name="direction_24")
    private String direction_24;

    @Column(name="direction_25")
    private String direction_25;

    @Column(name="direction_26")
    private String direction_26;

    @Column(name="direction_27")
    private String direction_27;

    @Column(name="direction_28")
    private String direction_28;

    @Column(name="direction_29")
    private String direction_29;

    @Column(name="direction_30")
    private String direction_30;

    @Column(name="direction_31")
    private String direction_31;

    @Column(name="direction_32")
    private String direction_32;

    @Column(name="direction_33")
    private String direction_33;

    @Column(name="direction_34")
    private String direction_34;

    @Column(name="direction_35")
    private String direction_35;

    @Column(name="direction_36")
    private String direction_36;

    @Column(name="direction_37")
    private String direction_37;

    @Column(name="direction_38")
    private String direction_38;

    @Column(name="direction_39")
    private String direction_39;

    @Column(name="direction_40")
    private String direction_40;

    @Column(name="direction_41")
    private String direction_41;

    @Column(name="direction_42")
    private String direction_42;

    @Column(name="direction_43")
    private String direction_43;

    @Column(name="direction_44")
    private String direction_44;

    @Column(name="direction_45")
    private String direction_45;

    @Column(name="direction_46")
    private String direction_46;

    @Column(name="direction_47")
    private String direction_47;

    @Column(name="direction_48")
    private String direction_48;

    @Column(name="direction_49")
    private String direction_49;

    @Column(name="direction_50")
    private String direction_50;


}
