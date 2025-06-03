package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author praveen s
 */
public class MachineryDetailsTab implements Serializable {

    // 1
    @NotNull(message = "MainEng Make is required")
    @SerializedName("me_make")
    @Expose
    private String mainEngineMake;

    // 2
    @NotNull(message = "NoOfCylinder is required")
    @SerializedName("noof_cylinder")
    @Expose
    private Integer noOfCylinder;

    // 3
    @NotNull(message = "This Field is required")
    @SerializedName("mcr_ps_rpm")
    @Expose
    private String mcrPs;

    // 4
    @NotNull(message = "This Field is required")
    @SerializedName("camlessornot")
    @Expose
    private String camlessornot;

    // 5
    @NotNull(message = "License is required")
    @SerializedName("license")
    @Expose
    private String license;

    // 6
    @NotNull(message = "This Field is required")
    @SerializedName("nsr_ps_rpm")
    @Expose
    private String nsrPs;

    // 7
    @NotNull(message = "This Field is required")
    @SerializedName("me_turbocharger_make")
    @Expose
    private String turboChargerMake;

    @NotNull(message = "MainEng Type is required")
    @SerializedName("me_type")
    @Expose
    private String mainEngineType;

    @NotNull(message = "This Field is required")
    @SerializedName("mcr_kw_rpm")
    @Expose
    private String mcrKw;

    @NotNull(message = "This Field is required")
    @SerializedName("nsr_kw_rpm")
    @Expose
    private String nsrKw;

     @NotNull(message = "This Field is required")
    @SerializedName("me_turbocharger_type")
    @Expose
    private String turboChargerType;

    public String getMcrKw() {
        return mcrKw;
    }

    public void setMcrKw(String mcrKw) {
        this.mcrKw = mcrKw;
    }

    public String getNsrKw() {
        return nsrKw;
    }

    public void setNsrKw(String nsrKw) {
        this.nsrKw = nsrKw;
    }

    public String getTurboChargerType() {
        return turboChargerType;
    }

    public void setTurboChargerType(String turboChargerType) {
        this.turboChargerType = turboChargerType;
    }
     
     
     
    public String getMainEngineType() {
        return mainEngineType;
    }

    public void setMainEngineType(String mainEngineType) {
        this.mainEngineType = mainEngineType;
    }

    public String getMainEngineMake() {
        return mainEngineMake;
    }

    public void setMainEngineMake(String mainEngineMake) {
        this.mainEngineMake = mainEngineMake;
    }

    public Integer getNoOfCylinder() {
        return noOfCylinder;
    }

    public void setNoOfCylinder(Integer noOfCylinder) {
        this.noOfCylinder = noOfCylinder;
    }

    public String getMcrPs() {
        return mcrPs;
    }

    public void setMcrPs(String mcrPs) {
        this.mcrPs = mcrPs;
    }

    public String getCamlessornot() {
        return camlessornot;
    }

    public void setCamlessornot(String camlessornot) {
        this.camlessornot = camlessornot;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getNsrPs() {
        return nsrPs;
    }

    public void setNsrPs(String nsrPs) {
        this.nsrPs = nsrPs;
    }

    public String getTurboChargerMake() {
        return turboChargerMake;
    }

    public void setTurboChargerMake(String turboChargerMake) {
        this.turboChargerMake = turboChargerMake;
    }

}
