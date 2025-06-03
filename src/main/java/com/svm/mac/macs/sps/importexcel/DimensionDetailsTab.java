package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author praveen s
 */
public class DimensionDetailsTab implements Serializable {

    // 1
    @NotNull(message = "Length is required")
    @SerializedName("length_loa")
    @Expose
    private String lengthloa;

    // 2
    @NotNull(message = "LBP is required")
    @SerializedName("lbp")
    @Expose
    private String lbp;

    // 3
    @NotNull(message = "Breadth is required")
    @SerializedName("breadth")
    @Expose
    private String breadth;

    // 4
    @NotNull(message = "Height is required")
    @SerializedName("height")
    @Expose
    private String height;

    // 5
    @NotNull(message = "Depth is required")
    @SerializedName("depth")
    @Expose
    private String depth;

    // 6
    @NotNull(message = "Draft is required")
    @SerializedName("draft")
    @Expose
    private String draft;

    // 7
    @NotNull(message = "DeadWeight is required")
    @SerializedName("deadweight")
    @Expose
    private String deadweight;

    // 8
    @NotNull(message = "Capacity is required")
    @SerializedName("capacity")
    @Expose
    private String capacity;

    // 9
    @NotNull(message = "International Gross Ton is required")
    @SerializedName("international_grosston")
    @Expose
    private String internationalGrosston;

    // 10
    @NotNull(message = "International NetTon is required")
    @SerializedName("international_netton")
    @Expose
    private String internationalNetton;

    // 11
    @NotNull(message = "registered Gross Ton is required")
    @SerializedName("registered_grosston")
    @Expose
    private String registeredGrosston;

    // 12
    @NotNull(message = "registered Net Ton is required")
    @SerializedName("registered_netton")
    @Expose
    private String registeredNetton;

    // 13
    @NotNull(message = "GT Suez is required")
    @SerializedName("gt_suez")
    @Expose
    private String gtSuez;

    // 14
    @NotNull(message = "NT Suez is required")
    @SerializedName("nt_suez")
    @Expose
    private String ntSuez;

    // 15
    @NotNull(message = "GT Pan is required")
    @SerializedName("gt_pan")
    @Expose
    private String gtpan;

    // 16
    @NotNull(message = "MS/UMS is required")
    @SerializedName("ms_ums")
    @Expose
    private String msums;

    // 17
    @NotNull(message = "Light Ship is required")
    @SerializedName("lightship")
    @Expose
    private String lightShip;

    // 18
    @NotNull(message = "Constant is required")
    @SerializedName("constant")
    @Expose
    private String constant;

    public String getLengthloa() {
        return lengthloa;
    }

    public void setLengthloa(String lengthloa) {
        this.lengthloa = lengthloa;
    }

    public String getLbp() {
        return lbp;
    }

    public void setLbp(String lbp) {
        this.lbp = lbp;
    }

    public String getBreadth() {
        return breadth;
    }

    public void setBreadth(String breadth) {
        this.breadth = breadth;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
    }

    public String getDeadweight() {
        return deadweight;
    }

    public void setDeadweight(String deadweight) {
        this.deadweight = deadweight;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getInternationalGrosston() {
        return internationalGrosston;
    }

    public void setInternationalGrosston(String internationalGrosston) {
        this.internationalGrosston = internationalGrosston;
    }

    public String getInternationalNetton() {
        return internationalNetton;
    }

    public void setInternationalNetton(String internationalNetton) {
        this.internationalNetton = internationalNetton;
    }

    public String getRegisteredGrosston() {
        return registeredGrosston;
    }

    public void setRegisteredGrosston(String registeredGrosston) {
        this.registeredGrosston = registeredGrosston;
    }

    public String getRegisteredNetton() {
        return registeredNetton;
    }

    public void setRegisteredNetton(String registeredNetton) {
        this.registeredNetton = registeredNetton;
    }

    public String getGtSuez() {
        return gtSuez;
    }

    public void setGtSuez(String gtSuez) {
        this.gtSuez = gtSuez;
    }

    public String getNtSuez() {
        return ntSuez;
    }

    public void setNtSuez(String ntSuez) {
        this.ntSuez = ntSuez;
    }

    public String getGtpan() {
        return gtpan;
    }

    public void setGtpan(String gtpan) {
        this.gtpan = gtpan;
    }

    public String getMsums() {
        return msums;
    }

    public void setMsums(String msums) {
        this.msums = msums;
    }

    public String getLightShip() {
        return lightShip;
    }

    public void setLightShip(String lightShip) {
        this.lightShip = lightShip;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

}
