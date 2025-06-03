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
public class rankmaster implements Serializable {

    @SerializedName(value = "upddate")
    @Expose
    private String upddate;
    
    @SerializedName(value = "rankcode")
    @Expose
    private String rankcode;
    
    @SerializedName(value = "active_status")
    @Expose
    private String active_status;
    
    @SerializedName(value = "cruser")
    @Expose
    private String cruser;
    
    @SerializedName(value = "crdate")
    @Expose
    private String crdate;
    
    @SerializedName(value = "rankname")
    @Expose
    private String rankname;
    
    @SerializedName(value = "upduser")
    @Expose
    private String upduser;

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getRankcode() {
        return rankcode;
    }

    public void setRankcode(String rankcode) {
        this.rankcode = rankcode;
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

    public String getCrdate() {
        return crdate;
    }

    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

}
