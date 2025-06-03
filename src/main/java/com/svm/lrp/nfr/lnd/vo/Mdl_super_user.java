/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author naveenkumar.sakthi
 */
public class Mdl_super_user implements Serializable {
    
    @SerializedName("crdate")
    @Expose
    private String crdate;
    
    @SerializedName("cruser")
    @Expose
    private String cruser;
    
    @SerializedName("id")
    @Expose
    private int id;
    
    @SerializedName("mdlcode")
    @Expose
    private String mdlcode;
    
    @SerializedName("companycode")
    @Expose
    private String companycode;
    
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("upduser")
    @Expose
    private String upduser;

    @SerializedName("usercode")
    @Expose
    private String usercode;

    public String getCrdate() {
        return crdate;
    }

    public void setCrdate(String crdate) {
        this.crdate = crdate;
    }

    public String getCruser() {
        return cruser;
    }

    public void setCruser(String cruser) {
        this.cruser = cruser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMdlcode() {
        return mdlcode;
    }

    public void setMdlcode(String mdlcode) {
        this.mdlcode = mdlcode;
    }

    public String getCompanycode() {
        return companycode;
    }

    public void setCompanycode(String companycode) {
        this.companycode = companycode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

}
