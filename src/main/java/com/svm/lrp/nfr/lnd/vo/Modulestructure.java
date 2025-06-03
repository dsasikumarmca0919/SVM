/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

/**
 *
 * @author vinothini.r
 */
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Modulestructure implements Serializable {

    @SerializedName("menuname")
    @Expose
    private String menuname;

    @SerializedName("landingpagetitle")
    @Expose
    private String landingpagetitle;

    @SerializedName("newtabenb")
    @Expose
    private String newtabenb;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getLandingpagetitle() {
        return landingpagetitle;
    }

    public void setLandingpagetitle(String landingpagetitle) {
        this.landingpagetitle = landingpagetitle;
    }

    public String getNewtabenb() {
        return newtabenb;
    }

    public void setNewtabenb(String newtabenb) {
        this.newtabenb = newtabenb;
    }

}
