package com.example.createrecipetin.Entity;

import jakarta.persistence.*;


@Entity
@Table(name="directions")
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
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

    public String getDirection_1() {
        return direction_1;
    }

    public void setDirection_1(String direction_1) {
        this.direction_1 = direction_1;
    }

    public String getDirection_2() {
        return direction_2;
    }

    public void setDirection_2(String direction_2) {
        this.direction_2 = direction_2;
    }

    public String getDirection_3() {
        return direction_3;
    }

    public void setDirection_3(String direction_3) {
        this.direction_3 = direction_3;
    }

    public String getDirection_4() {
        return direction_4;
    }

    public void setDirection_4(String direction_4) {
        this.direction_4 = direction_4;
    }

    public String getDirection_5() {
        return direction_5;
    }

    public void setDirection_5(String direction_5) {
        this.direction_5 = direction_5;
    }

    public String getDirection_6() {
        return direction_6;
    }

    public void setDirection_6(String direction_6) {
        this.direction_6 = direction_6;
    }

    public String getDirection_7() {
        return direction_7;
    }

    public void setDirection_7(String direction_7) {
        this.direction_7 = direction_7;
    }

    public String getDirection_8() {
        return direction_8;
    }

    public void setDirection_8(String direction_8) {
        this.direction_8 = direction_8;
    }

    public String getDirection_9() {
        return direction_9;
    }

    public void setDirection_9(String direction_9) {
        this.direction_9 = direction_9;
    }

    public String getDirection_10() {
        return direction_10;
    }

    public void setDirection_10(String direction_10) {
        this.direction_10 = direction_10;
    }

    public String getDirection_11() {
        return direction_11;
    }

    public void setDirection_11(String direction_11) {
        this.direction_11 = direction_11;
    }

    public String getDirection_12() {
        return direction_12;
    }

    public void setDirection_12(String direction_12) {
        this.direction_12 = direction_12;
    }

    public String getDirection_13() {
        return direction_13;
    }

    public void setDirection_13(String direction_13) {
        this.direction_13 = direction_13;
    }

    public String getDirection_14() {
        return direction_14;
    }

    public void setDirection_14(String direction_14) {
        this.direction_14 = direction_14;
    }

    public String getDirection_15() {
        return direction_15;
    }

    public void setDirection_15(String direction_15) {
        this.direction_15 = direction_15;
    }

    public String getDirection_16() {
        return direction_16;
    }

    public void setDirection_16(String direction_16) {
        this.direction_16 = direction_16;
    }

    public String getDirection_17() {
        return direction_17;
    }

    public void setDirection_17(String direction_17) {
        this.direction_17 = direction_17;
    }

    public String getDirection_18() {
        return direction_18;
    }

    public void setDirection_18(String direction_18) {
        this.direction_18 = direction_18;
    }

    public String getDirection_19() {
        return direction_19;
    }

    public void setDirection_19(String direction_19) {
        this.direction_19 = direction_19;
    }

    public String getDirection_20() {
        return direction_20;
    }

    public void setDirection_20(String direction_20) {
        this.direction_20 = direction_20;
    }

    public String getDirection_21() {
        return direction_21;
    }

    public void setDirection_21(String direction_21) {
        this.direction_21 = direction_21;
    }

    public String getDirection_22() {
        return direction_22;
    }

    public void setDirection_22(String direction_22) {
        this.direction_22 = direction_22;
    }

    public String getDirection_23() {
        return direction_23;
    }

    public void setDirection_23(String direction_23) {
        this.direction_23 = direction_23;
    }

    public String getDirection_24() {
        return direction_24;
    }

    public void setDirection_24(String direction_24) {
        this.direction_24 = direction_24;
    }

    public String getDirection_25() {
        return direction_25;
    }

    public void setDirection_25(String direction_25) {
        this.direction_25 = direction_25;
    }

    public String getDirection_26() {
        return direction_26;
    }

    public void setDirection_26(String direction_26) {
        this.direction_26 = direction_26;
    }

    public String getDirection_27() {
        return direction_27;
    }

    public void setDirection_27(String direction_27) {
        this.direction_27 = direction_27;
    }

    public String getDirection_28() {
        return direction_28;
    }

    public void setDirection_28(String direction_28) {
        this.direction_28 = direction_28;
    }

    public String getDirection_29() {
        return direction_29;
    }

    public void setDirection_29(String direction_29) {
        this.direction_29 = direction_29;
    }

    public String getDirection_30() {
        return direction_30;
    }

    public void setDirection_30(String direction_30) {
        this.direction_30 = direction_30;
    }

    public String getDirection_31() {
        return direction_31;
    }

    public void setDirection_31(String direction_31) {
        this.direction_31 = direction_31;
    }

    public String getDirection_32() {
        return direction_32;
    }

    public void setDirection_32(String direction_32) {
        this.direction_32 = direction_32;
    }

    public String getDirection_33() {
        return direction_33;
    }

    public void setDirection_33(String direction_33) {
        this.direction_33 = direction_33;
    }

    public String getDirection_34() {
        return direction_34;
    }

    public void setDirection_34(String direction_34) {
        this.direction_34 = direction_34;
    }

    public String getDirection_35() {
        return direction_35;
    }

    public void setDirection_35(String direction_35) {
        this.direction_35 = direction_35;
    }

    public String getDirection_36() {
        return direction_36;
    }

    public void setDirection_36(String direction_36) {
        this.direction_36 = direction_36;
    }

    public String getDirection_37() {
        return direction_37;
    }

    public void setDirection_37(String direction_37) {
        this.direction_37 = direction_37;
    }

    public String getDirection_38() {
        return direction_38;
    }

    public void setDirection_38(String direction_38) {
        this.direction_38 = direction_38;
    }

    public String getDirection_39() {
        return direction_39;
    }

    public void setDirection_39(String direction_39) {
        this.direction_39 = direction_39;
    }

    public String getDirection_40() {
        return direction_40;
    }

    public void setDirection_40(String direction_40) {
        this.direction_40 = direction_40;
    }

    public String getDirection_41() {
        return direction_41;
    }

    public void setDirection_41(String direction_41) {
        this.direction_41 = direction_41;
    }

    public String getDirection_42() {
        return direction_42;
    }

    public void setDirection_42(String direction_42) {
        this.direction_42 = direction_42;
    }

    public String getDirection_43() {
        return direction_43;
    }

    public void setDirection_43(String direction_43) {
        this.direction_43 = direction_43;
    }

    public String getDirection_44() {
        return direction_44;
    }

    public void setDirection_44(String direction_44) {
        this.direction_44 = direction_44;
    }

    public String getDirection_45() {
        return direction_45;
    }

    public void setDirection_45(String direction_45) {
        this.direction_45 = direction_45;
    }

    public String getDirection_46() {
        return direction_46;
    }

    public void setDirection_46(String direction_46) {
        this.direction_46 = direction_46;
    }

    public String getDirection_47() {
        return direction_47;
    }

    public void setDirection_47(String direction_47) {
        this.direction_47 = direction_47;
    }

    public String getDirection_48() {
        return direction_48;
    }

    public void setDirection_48(String direction_48) {
        this.direction_48 = direction_48;
    }

    public String getDirection_49() {
        return direction_49;
    }

    public void setDirection_49(String direction_49) {
        this.direction_49 = direction_49;
    }

    public String getDirection_50() {
        return direction_50;
    }

    public void setDirection_50(String direction_50) {
        this.direction_50 = direction_50;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", direction_1='" + direction_1 + '\'' +
                ", direction_2='" + direction_2 + '\'' +
                ", direction_3='" + direction_3 + '\'' +
                ", direction_4='" + direction_4 + '\'' +
                ", direction_5='" + direction_5 + '\'' +
                ", direction_6='" + direction_6 + '\'' +
                ", direction_7='" + direction_7 + '\'' +
                ", direction_8='" + direction_8 + '\'' +
                ", direction_9='" + direction_9 + '\'' +
                ", direction_10='" + direction_10 + '\'' +
                ", direction_11='" + direction_11 + '\'' +
                ", direction_12='" + direction_12 + '\'' +
                ", direction_13='" + direction_13 + '\'' +
                ", direction_14='" + direction_14 + '\'' +
                ", direction_15='" + direction_15 + '\'' +
                ", direction_16='" + direction_16 + '\'' +
                ", direction_17='" + direction_17 + '\'' +
                ", direction_18='" + direction_18 + '\'' +
                ", direction_19='" + direction_19 + '\'' +
                ", direction_20='" + direction_20 + '\'' +
                ", direction_21='" + direction_21 + '\'' +
                ", direction_22='" + direction_22 + '\'' +
                ", direction_23='" + direction_23 + '\'' +
                ", direction_24='" + direction_24 + '\'' +
                ", direction_25='" + direction_25 + '\'' +
                ", direction_26='" + direction_26 + '\'' +
                ", direction_27='" + direction_27 + '\'' +
                ", direction_28='" + direction_28 + '\'' +
                ", direction_29='" + direction_29 + '\'' +
                ", direction_30='" + direction_30 + '\'' +
                ", direction_31='" + direction_31 + '\'' +
                ", direction_32='" + direction_32 + '\'' +
                ", direction_33='" + direction_33 + '\'' +
                ", direction_34='" + direction_34 + '\'' +
                ", direction_35='" + direction_35 + '\'' +
                ", direction_36='" + direction_36 + '\'' +
                ", direction_37='" + direction_37 + '\'' +
                ", direction_38='" + direction_38 + '\'' +
                ", direction_39='" + direction_39 + '\'' +
                ", direction_40='" + direction_40 + '\'' +
                ", direction_41='" + direction_41 + '\'' +
                ", direction_42='" + direction_42 + '\'' +
                ", direction_43='" + direction_43 + '\'' +
                ", direction_44='" + direction_44 + '\'' +
                ", direction_45='" + direction_45 + '\'' +
                ", direction_46='" + direction_46 + '\'' +
                ", direction_47='" + direction_47 + '\'' +
                ", direction_48='" + direction_48 + '\'' +
                ", direction_49='" + direction_49 + '\'' +
                ", direction_50='" + direction_50 + '\'' +
                '}';
    }
}
