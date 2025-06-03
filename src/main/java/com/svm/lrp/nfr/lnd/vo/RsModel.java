package com.svm.lrp.nfr.lnd.vo;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author Rahul.Thennarasu
 */
public class RsModel {

    @SerializedName("rs0")
    @Expose
    private List<Rs0> rs0 = null;
    
     @SerializedName("rs1")
    @Expose
    private List<Rs1> rs1 = null;
     
    @SerializedName("rs2")
    @Expose
    private List<Rs2> rs2 = null;
     
    @SerializedName("rs3")
    @Expose
    private List<Rs3> rs3 = null;
    
    @SerializedName("rs4")
    @Expose
    private List<Rs4> rs4 = null;
    
    @SerializedName("rs5")
    @Expose
    private List<Rs5> rs5 = null;

    public List<Rs0> getRs0() {
        return rs0;
    }

    public void setRs0(List<Rs0> rs0) {
        this.rs0 = rs0;
    }

    public List<Rs1> getRs1() {
        return rs1;
    }

    public void setRs1(List<Rs1> rs1) {
        this.rs1 = rs1;
    }

    public List<Rs2> getRs2() {
        return rs2;
    }

    public void setRs2(List<Rs2> rs2) {
        this.rs2 = rs2;
    }

    public List<Rs3> getRs3() {
        return rs3;
    }

    public void setRs3(List<Rs3> rs3) {
        this.rs3 = rs3;
    }

    public List<Rs4> getRs4() {
        return rs4;
    }

    public void setRs4(List<Rs4> rs4) {
        this.rs4 = rs4;
    }

    public List<Rs5> getRs5() {
        return rs5;
    }

    public void setRs5(List<Rs5> rs5) {
        this.rs5 = rs5;
    }

    
    
    
    
}