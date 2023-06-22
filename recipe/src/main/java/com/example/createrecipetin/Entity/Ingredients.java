package com.example.createrecipetin.Entity;


import jakarta.persistence.*;

import java.lang.reflect.Field;

@Entity
@Table(name="ingredients")
public class Ingredients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getIngredient_1() {
        return ingredient_1;
    }

    public void setIngredient_1(String ingredient_1) {
        this.ingredient_1 = ingredient_1;
    }

    public String getIngredient_2() {
        return ingredient_2;
    }

    public void setIngredient_2(String ingredient_2) {
        this.ingredient_2 = ingredient_2;
    }

    public String getIngredient_3() {
        return ingredient_3;
    }

    public void setIngredient_3(String ingredient_3) {
        this.ingredient_3 = ingredient_3;
    }

    public String getIngredient_4() {
        return ingredient_4;
    }

    public void setIngredient_4(String ingredient_4) {
        this.ingredient_4 = ingredient_4;
    }

    public String getIngredient_5() {
        return ingredient_5;
    }

    public void setIngredient_5(String ingredient_5) {
        this.ingredient_5 = ingredient_5;
    }

    public String getIngredient_6() {
        return ingredient_6;
    }

    public void setIngredient_6(String ingredient_6) {
        this.ingredient_6 = ingredient_6;
    }

    public String getIngredient_7() {
        return ingredient_7;
    }

    public void setIngredient_7(String ingredient_7) {
        this.ingredient_7 = ingredient_7;
    }

    public String getIngredient_8() {
        return ingredient_8;
    }

    public void setIngredient_8(String ingredient_8) {
        this.ingredient_8 = ingredient_8;
    }

    public String getIngredient_9() {
        return ingredient_9;
    }

    public void setIngredient_9(String ingredient_9) {
        this.ingredient_9 = ingredient_9;
    }

    public String getIngredient_10() {
        return ingredient_10;
    }

    public void setIngredient_10(String ingredient_10) {
        this.ingredient_10 = ingredient_10;
    }

    public String getIngredient_11() {
        return ingredient_11;
    }

    public void setIngredient_11(String ingredient_11) {
        this.ingredient_11 = ingredient_11;
    }

    public String getIngredient_12() {
        return ingredient_12;
    }

    public void setIngredient_12(String ingredient_12) {
        this.ingredient_12 = ingredient_12;
    }

    public String getIngredient_13() {
        return ingredient_13;
    }

    public void setIngredient_13(String ingredient_13) {
        this.ingredient_13 = ingredient_13;
    }

    public String getIngredient_14() {
        return ingredient_14;
    }

    public void setIngredient_14(String ingredient_14) {
        this.ingredient_14 = ingredient_14;
    }

    public String getIngredient_15() {
        return ingredient_15;
    }

    public void setIngredient_15(String ingredient_15) {
        this.ingredient_15 = ingredient_15;
    }

    public String getIngredient_16() {
        return ingredient_16;
    }

    public void setIngredient_16(String ingredient_16) {
        this.ingredient_16 = ingredient_16;
    }

    public String getIngredient_17() {
        return ingredient_17;
    }

    public void setIngredient_17(String ingredient_17) {
        this.ingredient_17 = ingredient_17;
    }

    public String getIngredient_18() {
        return ingredient_18;
    }

    public void setIngredient_18(String ingredient_18) {
        this.ingredient_18 = ingredient_18;
    }

    public String getIngredient_19() {
        return ingredient_19;
    }

    public void setIngredient_19(String ingredient_19) {
        this.ingredient_19 = ingredient_19;
    }

    public String getIngredient_20() {
        return ingredient_20;
    }

    public void setIngredient_20(String ingredient_20) {
        this.ingredient_20 = ingredient_20;
    }

    public String getIngredient_21() {
        return ingredient_21;
    }

    public void setIngredient_21(String ingredient_21) {
        this.ingredient_21 = ingredient_21;
    }

    public String getIngredient_22() {
        return ingredient_22;
    }

    public void setIngredient_22(String ingredient_22) {
        this.ingredient_22 = ingredient_22;
    }

    public String getIngredient_23() {
        return ingredient_23;
    }

    public void setIngredient_23(String ingredient_23) {
        this.ingredient_23 = ingredient_23;
    }

    public String getIngredient_24() {
        return ingredient_24;
    }

    public void setIngredient_24(String ingredient_24) {
        this.ingredient_24 = ingredient_24;
    }

    public String getIngredient_25() {
        return ingredient_25;
    }

    public void setIngredient_25(String ingredient_25) {
        this.ingredient_25 = ingredient_25;
    }

    public String getIngredient_26() {
        return ingredient_26;
    }

    public void setIngredient_26(String ingredient_26) {
        this.ingredient_26 = ingredient_26;
    }

    public String getIngredient_27() {
        return ingredient_27;
    }

    public void setIngredient_27(String ingredient_27) {
        this.ingredient_27 = ingredient_27;
    }

    public String getIngredient_28() {
        return ingredient_28;
    }

    public void setIngredient_28(String ingredient_28) {
        this.ingredient_28 = ingredient_28;
    }

    public String getIngredient_29() {
        return ingredient_29;
    }

    public void setIngredient_29(String ingredient_29) {
        this.ingredient_29 = ingredient_29;
    }

    public String getIngredient_30() {
        return ingredient_30;
    }

    public void setIngredient_30(String ingredient_30) {
        this.ingredient_30 = ingredient_30;
    }

    public String getIngredient_31() {
        return ingredient_31;
    }

    public void setIngredient_31(String ingredient_31) {
        this.ingredient_31 = ingredient_31;
    }

    public String getIngredient_32() {
        return ingredient_32;
    }

    public void setIngredient_32(String ingredient_32) {
        this.ingredient_32 = ingredient_32;
    }

    public String getIngredient_33() {
        return ingredient_33;
    }

    public void setIngredient_33(String ingredient_33) {
        this.ingredient_33 = ingredient_33;
    }

    public String getIngredient_34() {
        return ingredient_34;
    }

    public void setIngredient_34(String ingredient_34) {
        this.ingredient_34 = ingredient_34;
    }

    public String getIngredient_35() {
        return ingredient_35;
    }

    public void setIngredient_35(String ingredient_35) {
        this.ingredient_35 = ingredient_35;
    }

    public String getIngredient_36() {
        return ingredient_36;
    }

    public void setIngredient_36(String ingredient_36) {
        this.ingredient_36 = ingredient_36;
    }

    public String getIngredient_37() {
        return ingredient_37;
    }

    public void setIngredient_37(String ingredient_37) {
        this.ingredient_37 = ingredient_37;
    }

    public String getIngredient_38() {
        return ingredient_38;
    }

    public void setIngredient_38(String ingredient_38) {
        this.ingredient_38 = ingredient_38;
    }

    public String getIngredient_39() {
        return ingredient_39;
    }

    public void setIngredient_39(String ingredient_39) {
        this.ingredient_39 = ingredient_39;
    }

    public String getIngredient_40() {
        return ingredient_40;
    }

    public void setIngredient_40(String ingredient_40) {
        this.ingredient_40 = ingredient_40;
    }

    public String getIngredient_41() {
        return ingredient_41;
    }

    public void setIngredient_41(String ingredient_41) {
        this.ingredient_41 = ingredient_41;
    }

    public String getIngredient_42() {
        return ingredient_42;
    }

    public void setIngredient_42(String ingredient_42) {
        this.ingredient_42 = ingredient_42;
    }

    public String getIngredient_43() {
        return ingredient_43;
    }

    public void setIngredient_43(String ingredient_43) {
        this.ingredient_43 = ingredient_43;
    }

    public String getIngredient_44() {
        return ingredient_44;
    }

    public void setIngredient_44(String ingredient_44) {
        this.ingredient_44 = ingredient_44;
    }

    public String getIngredient_45() {
        return ingredient_45;
    }

    public void setIngredient_45(String ingredient_45) {
        this.ingredient_45 = ingredient_45;
    }

    public String getIngredient_46() {
        return ingredient_46;
    }

    public void setIngredient_46(String ingredient_46) {
        this.ingredient_46 = ingredient_46;
    }

    public String getIngredient_47() {
        return ingredient_47;
    }

    public void setIngredient_47(String ingredient_47) {
        this.ingredient_47 = ingredient_47;
    }

    public String getIngredient_48() {
        return ingredient_48;
    }

    public void setIngredient_48(String ingredient_48) {
        this.ingredient_48 = ingredient_48;
    }

    public String getIngredient_49() {
        return ingredient_49;
    }

    public void setIngredient_49(String ingredient_49) {
        this.ingredient_49 = ingredient_49;
    }

    public String getIngredient_50() {
        return ingredient_50;
    }

    public void setIngredient_50(String ingredient_50) {
        this.ingredient_50 = ingredient_50;
    }

    /**
     *  Use library Reflections to create a toString() method. That doesn't print null ingredient_N columns.
     *  Since I have no idea is a column is null we have to relly on Reflections to introspect itself.
     *  Delete function when no longer needed.
     * */
    @Override
    public String toString() {
        //Get all field objects of the class
        Field[] fields = Ingredients.class.getDeclaredFields();
        String ans = "Ingredients{";
        for(int i=0; i< fields.length; i++){

            try {
                if( (i<2) || ( (i>1) && (fields[i].get(this) != null) ) ){

                    fields[i].setAccessible(true);
                    //get value of the field
                    String value = (String) fields[i].get(this);

                    if(i==0){
                        ans += fields[i].getName() + " = " + value ;
                    }else if(i==1){
                        ans += ", "+ fields[i].getName() + " = " + value ;
                    }
                    else{
                        ans += ", "+ fields[i].getName() + " = " + "\'"+ value + "\'" ;

                    }
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        ans += "}";
        return ans;

    }
}
