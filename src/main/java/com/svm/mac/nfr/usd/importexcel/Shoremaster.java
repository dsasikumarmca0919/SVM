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
public class Shoremaster implements Serializable {

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("cruser")
    @Expose
    private String cruser;

    @SerializedName("shorecode")
    @Expose
    private String shorecode;

    @SerializedName("crdate")
    @Expose
    private String crdate;

    @SerializedName("upduser")
    @Expose
    private String upduser;

    @SerializedName("shorename")
    @Expose
    private String shorename;

    @SerializedName("ishead")
    @Expose
    private String ishead;

    @SerializedName("corporateid")
    @Expose
    private int corporateid;

    public String getIshead() {
        return ishead;
    }

    public void setIshead(String ishead) {
        this.ishead = ishead;
    }

    public int getCorporateid() {
        return corporateid;
    }

    public void setCorporateid(int corporateid) {
        this.corporateid = corporateid;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public String getShorecode() {
        return shorecode;
    }

    public void setShorecode(String shorecode) {
        this.shorecode = shorecode;
    }

    public String getCrdate() {
        return crdate;
    }

    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getShorename() {
        return shorename;
    }

    public void setShorename(String shorename) {
        this.shorename = shorename;
    }
}
