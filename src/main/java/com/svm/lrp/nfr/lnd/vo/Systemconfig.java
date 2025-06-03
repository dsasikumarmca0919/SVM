/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Systemconfig implements Serializable {

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("sysvalue")
    @Expose
    private String sysvalue;

    @SerializedName("cruser")
    @Expose
    private String cruser;

    @SerializedName("crdate")
    @Expose
    private String crdate;

    @SerializedName("upduser")
    @Expose
    private String upduser;

    @SerializedName("sysparam")
    @Expose
    private String sysparam;

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

    public String getSysvalue() {
        return sysvalue;
    }

    public void setSysvalue(String sysvalue) {
        this.sysvalue = sysvalue;
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

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getSysparam() {
        return sysparam;
    }

    public void setSysparam(String sysparam) {
        this.sysparam = sysparam;
    }

}
