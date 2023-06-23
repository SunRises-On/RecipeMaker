package com.example.createrecipetin.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.lang.reflect.Field;


@Entity
@Table(name="instructions")
public class Instructions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JsonBackReference

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @Lob
    @Column(name="instruction_1", length=512)
    private String instruction_1;

    @Lob
    @Column(name="instruction_2", length=512)
    private String instruction_2;

    @Lob
    @Column(name="instruction_3", length=512)
    private String instruction_3;

    @Lob
    @Column(name="instruction_4", length=512)
    private String instruction_4;

    @Lob
    @Column(name="instruction_5", length=512)
    private String instruction_5;

    @Lob
    @Column(name="instruction_6", length=512)
    private String instruction_6;

    @Lob
    @Column(name="instruction_7", length=512)
    private String instruction_7;

    @Lob
    @Column(name="instruction_8", length=512)
    private String instruction_8;

    @Lob
    @Column(name="instruction_9", length=512)
    private String instruction_9;

    @Lob
    @Column(name="instruction_10", length=512)
    private String instruction_10;

    @Lob
    @Column(name="instruction_11", length=512)
    private String instruction_11;

    @Lob
    @Column(name="instruction_12", length=512)
    private String instruction_12;

    @Lob
    @Column(name="instruction_13", length=512)
    private String instruction_13;

    @Lob
    @Column(name="instruction_14", length=512)
    private String instruction_14;

    @Lob
    @Column(name="instruction_15", length=512)
    private String instruction_15;

    @Lob
    @Column(name="instruction_16", length=512)
    private String instruction_16;

    @Lob
    @Column(name="instruction_17", length=512)
    private String instruction_17;

    @Lob
    @Column(name="instruction_18", length=512)
    private String instruction_18;

    @Lob
    @Column(name="instruction_19", length=512)
    private String instruction_19;

    @Lob
    @Column(name="instruction_20", length=512)
    private String instruction_20;

    @Lob
    @Column(name="instruction_21", length=512)
    private String instruction_21;

    @Lob
    @Column(name="instruction_22", length=512)
    private String instruction_22;

    @Lob
    @Column(name="instruction_23", length=512)
    private String instruction_23;

    @Lob
    @Column(name="instruction_24", length=512)
    private String instruction_24;

    @Lob
    @Column(name="instruction_25", length=512)
    private String instruction_25;

    @Lob
    @Column(name="instruction_26", length=512)
    private String instruction_26;

    @Lob
    @Column(name="instruction_27", length=512)
    private String instruction_27;

    @Lob
    @Column(name="instruction_28", length=512)
    private String instruction_28;

    @Lob
    @Column(name="instruction_29", length=512)
    private String instruction_29;

    @Lob
    @Column(name="instruction_30", length=512)
    private String instruction_30;

    @Lob
    @Column(name="instruction_31", length=512)
    private String instruction_31;

    @Lob
    @Column(name="instruction_32", length=512)
    private String instruction_32;

    @Lob
    @Column(name="instruction_33", length=512)
    private String instruction_33;

    @Lob
    @Column(name="instruction_34", length=512)
    private String instruction_34;

    @Lob
    @Column(name="instruction_35", length=512)
    private String instruction_35;

    @Lob
    @Column(name="instruction_36", length=512)
    private String instruction_36;

    @Lob
    @Column(name="instruction_37", length=512)
    private String instruction_37;

    @Lob
    @Column(name="instruction_38", length=512)
    private String instruction_38;

    @Lob
    @Column(name="instruction_39", length=512)
    private String instruction_39;

    @Lob
    @Column(name="instruction_40", length=512)
    private String instruction_40;

    @Lob
    @Column(name="instruction_41", length=512)
    private String instruction_41;

    @Lob
    @Column(name="instruction_42", length=512)
    private String instruction_42;

    @Lob
    @Column(name="instruction_43", length=512)
    private String instruction_43;

    @Lob
    @Column(name="instruction_44", length=512)
    private String instruction_44;

    @Lob
    @Column(name="instruction_45", length=512)
    private String instruction_45;

    @Lob
    @Column(name="instruction_46", length=512)
    private String instruction_46;

    @Lob
    @Column(name="instruction_47", length=512)
    private String instruction_47;

    @Lob
    @Column(name="instruction_48", length=512)
    private String instruction_48;

    @Lob
    @Column(name="instruction_49", length=512)
    private String instruction_49;

    @Lob
    @Column(name="instruction_50", length=512)
    private String instruction_50;

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

    public String getInstruction_1() {
        return instruction_1;
    }

    public void setInstruction_1(String instruction_1) {
        this.instruction_1 = instruction_1;
    }

    public String getInstruction_2() {
        return instruction_2;
    }

    public void setInstruction_2(String instruction_2) {
        this.instruction_2 = instruction_2;
    }

    public String getInstruction_3() {
        return instruction_3;
    }

    public void setInstruction_3(String instruction_3) {
        this.instruction_3 = instruction_3;
    }

    public String getInstruction_4() {
        return instruction_4;
    }

    public void setInstruction_4(String instruction_4) {
        this.instruction_4 = instruction_4;
    }

    public String getInstruction_5() {
        return instruction_5;
    }

    public void setInstruction_5(String instruction_5) {
        this.instruction_5 = instruction_5;
    }

    public String getInstruction_6() {
        return instruction_6;
    }

    public void setInstruction_6(String instruction_6) {
        this.instruction_6 = instruction_6;
    }

    public String getInstruction_7() {
        return instruction_7;
    }

    public void setInstruction_7(String instruction_7) {
        this.instruction_7 = instruction_7;
    }

    public String getInstruction_8() {
        return instruction_8;
    }

    public void setInstruction_8(String instruction_8) {
        this.instruction_8 = instruction_8;
    }

    public String getInstruction_9() {
        return instruction_9;
    }

    public void setInstruction_9(String instruction_9) {
        this.instruction_9 = instruction_9;
    }

    public String getInstruction_10() {
        return instruction_10;
    }

    public void setInstruction_10(String instruction_10) {
        this.instruction_10 = instruction_10;
    }

    public String getInstruction_11() {
        return instruction_11;
    }

    public void setInstruction_11(String instruction_11) {
        this.instruction_11 = instruction_11;
    }

    public String getInstruction_12() {
        return instruction_12;
    }

    public void setInstruction_12(String instruction_12) {
        this.instruction_12 = instruction_12;
    }

    public String getInstruction_13() {
        return instruction_13;
    }

    public void setInstruction_13(String instruction_13) {
        this.instruction_13 = instruction_13;
    }

    public String getInstruction_14() {
        return instruction_14;
    }

    public void setInstruction_14(String instruction_14) {
        this.instruction_14 = instruction_14;
    }

    public String getInstruction_15() {
        return instruction_15;
    }

    public void setInstruction_15(String instruction_15) {
        this.instruction_15 = instruction_15;
    }

    public String getInstruction_16() {
        return instruction_16;
    }

    public void setInstruction_16(String instruction_16) {
        this.instruction_16 = instruction_16;
    }

    public String getInstruction_17() {
        return instruction_17;
    }

    public void setInstruction_17(String instruction_17) {
        this.instruction_17 = instruction_17;
    }

    public String getInstruction_18() {
        return instruction_18;
    }

    public void setInstruction_18(String instruction_18) {
        this.instruction_18 = instruction_18;
    }

    public String getInstruction_19() {
        return instruction_19;
    }

    public void setInstruction_19(String instruction_19) {
        this.instruction_19 = instruction_19;
    }

    public String getInstruction_20() {
        return instruction_20;
    }

    public void setInstruction_20(String instruction_20) {
        this.instruction_20 = instruction_20;
    }

    public String getInstruction_21() {
        return instruction_21;
    }

    public void setInstruction_21(String instruction_21) {
        this.instruction_21 = instruction_21;
    }

    public String getInstruction_22() {
        return instruction_22;
    }

    public void setInstruction_22(String instruction_22) {
        this.instruction_22 = instruction_22;
    }

    public String getInstruction_23() {
        return instruction_23;
    }

    public void setInstruction_23(String instruction_23) {
        this.instruction_23 = instruction_23;
    }

    public String getInstruction_24() {
        return instruction_24;
    }

    public void setInstruction_24(String instruction_24) {
        this.instruction_24 = instruction_24;
    }

    public String getInstruction_25() {
        return instruction_25;
    }

    public void setInstruction_25(String instruction_25) {
        this.instruction_25 = instruction_25;
    }

    public String getInstruction_26() {
        return instruction_26;
    }

    public void setInstruction_26(String instruction_26) {
        this.instruction_26 = instruction_26;
    }

    public String getInstruction_27() {
        return instruction_27;
    }

    public void setInstruction_27(String instruction_27) {
        this.instruction_27 = instruction_27;
    }

    public String getInstruction_28() {
        return instruction_28;
    }

    public void setInstruction_28(String instruction_28) {
        this.instruction_28 = instruction_28;
    }

    public String getInstruction_29() {
        return instruction_29;
    }

    public void setInstruction_29(String instruction_29) {
        this.instruction_29 = instruction_29;
    }

    public String getInstruction_30() {
        return instruction_30;
    }

    public void setInstruction_30(String instruction_30) {
        this.instruction_30 = instruction_30;
    }

    public String getInstruction_31() {
        return instruction_31;
    }

    public void setInstruction_31(String instruction_31) {
        this.instruction_31 = instruction_31;
    }

    public String getInstruction_32() {
        return instruction_32;
    }

    public void setInstruction_32(String instruction_32) {
        this.instruction_32 = instruction_32;
    }

    public String getInstruction_33() {
        return instruction_33;
    }

    public void setInstruction_33(String instruction_33) {
        this.instruction_33 = instruction_33;
    }

    public String getInstruction_34() {
        return instruction_34;
    }

    public void setInstruction_34(String instruction_34) {
        this.instruction_34 = instruction_34;
    }

    public String getInstruction_35() {
        return instruction_35;
    }

    public void setInstruction_35(String instruction_35) {
        this.instruction_35 = instruction_35;
    }

    public String getInstruction_36() {
        return instruction_36;
    }

    public void setInstruction_36(String instruction_36) {
        this.instruction_36 = instruction_36;
    }

    public String getInstruction_37() {
        return instruction_37;
    }

    public void setInstruction_37(String instruction_37) {
        this.instruction_37 = instruction_37;
    }

    public String getInstruction_38() {
        return instruction_38;
    }

    public void setInstruction_38(String instruction_38) {
        this.instruction_38 = instruction_38;
    }

    public String getInstruction_39() {
        return instruction_39;
    }

    public void setInstruction_39(String instruction_39) {
        this.instruction_39 = instruction_39;
    }

    public String getInstruction_40() {
        return instruction_40;
    }

    public void setInstruction_40(String instruction_40) {
        this.instruction_40 = instruction_40;
    }

    public String getInstruction_41() {
        return instruction_41;
    }

    public void setInstruction_41(String instruction_41) {
        this.instruction_41 = instruction_41;
    }

    public String getInstruction_42() {
        return instruction_42;
    }

    public void setInstruction_42(String instruction_42) {
        this.instruction_42 = instruction_42;
    }

    public String getInstruction_43() {
        return instruction_43;
    }

    public void setInstruction_43(String instruction_43) {
        this.instruction_43 = instruction_43;
    }

    public String getInstruction_44() {
        return instruction_44;
    }

    public void setInstruction_44(String instruction_44) {
        this.instruction_44 = instruction_44;
    }

    public String getInstruction_45() {
        return instruction_45;
    }

    public void setInstruction_45(String instruction_45) {
        this.instruction_45 = instruction_45;
    }

    public String getInstruction_46() {
        return instruction_46;
    }

    public void setInstruction_46(String instruction_46) {
        this.instruction_46 = instruction_46;
    }

    public String getInstruction_47() {
        return instruction_47;
    }

    public void setInstruction_47(String instruction_47) {
        this.instruction_47 = instruction_47;
    }

    public String getInstruction_48() {
        return instruction_48;
    }

    public void setInstruction_48(String instruction_48) {
        this.instruction_48 = instruction_48;
    }

    public String getInstruction_49() {
        return instruction_49;
    }

    public void setInstruction_49(String instruction_49) {
        this.instruction_49 = instruction_49;
    }

    public String getInstruction_50() {
        return instruction_50;
    }

    public void setInstruction_50(String instruction_50) {
        this.instruction_50 = instruction_50;
    }

    /**
     *  Use library Reflections to create a toString() method. That doesn't print null ingredient_N columns.
     *  Since I have no idea is a column is null we have to relly on Reflections to introspect itself.
     *  Delete function when no longer needed.
     * */
    @Override
    public String toString() {
        //Get all field objects of the class
        Field[] fields = Instructions.class.getDeclaredFields();
        String ans = "Instructions{";
        for(int i=0; i< fields.length; i++){

            try {
                if( (i<2) || ( (i>1) && (fields[i].get(this) != null) ) ){

                    fields[i].setAccessible(true);

                    if(i==0){
                        //get value of the field
                        ans += fields[i].getName() + " = " + getId() ;

                    }
                }else if(i==1){
                    String value = (String) fields[i].get(this);

                    ans += ", "+ fields[i].getName() + " = " + value ;
                }
                else{
                    String value = (String) fields[i].get(this);

                    ans += ", "+ fields[i].getName() + " = " + "\'"+ value + "\'" ;

                }
                } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

        }
        ans += "}";
        return ans;

    }
}
