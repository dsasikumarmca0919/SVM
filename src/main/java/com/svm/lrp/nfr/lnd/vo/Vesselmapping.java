/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vesselmapping implements Serializable {

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("vesselcode")
    @Expose
    private String vesselcode;

    @SerializedName("usercode")
    @Expose
    private String usercode;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("vesselname")
    @Expose
    private String vesselname;

    @SerializedName("shorecode")
    @Expose
    private String shorecode;

    public String getShorecode() {
        return shorecode;
    }

    public void setShorecode(String shorecode) {
        this.shorecode = shorecode;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getVesselcode() {
        return vesselcode;
    }

    public void setVesselcode(String vesselcode) {
        this.vesselcode = vesselcode;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVesselname() {
        return vesselname;
    }

    public void setVesselname(String vesselname) {
        this.vesselname = vesselname;
    }

}
