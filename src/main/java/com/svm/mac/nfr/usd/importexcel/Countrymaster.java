/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.mac.nfr.usd.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author d.manikandan
 */
public class Countrymaster implements Serializable {

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("udpuser")
    @Expose
    private String udpuser;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("countrycode")
    @Expose
    private String countrycode;

    @SerializedName("cruser")
    @Expose
    private String cruser;

    @SerializedName("countryname")
    @Expose
    private String countryname;

    @SerializedName("crdate")
    @Expose
    private String crdate;

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getUdpuser() {
        return udpuser;
    }

    public void setUdpuser(String udpuser) {
        this.udpuser = udpuser;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCrdate() {
        return crdate;
    }

    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }
}
