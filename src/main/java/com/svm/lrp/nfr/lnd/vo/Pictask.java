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

public class Pictask implements Serializable {

    @SerializedName("empname")
    @Expose
    private String empname;

    @SerializedName("revtargetdate")
    @Expose
    private String revtargetdate;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("picusercode")
    @Expose
    private String picusercode;

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getRevtargetdate() {
        return revtargetdate;
    }

    public void setRevtargetdate(String revtargetdate) {
        this.revtargetdate = revtargetdate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPicusercode() {
        return picusercode;
    }

    public void setPicusercode(String picusercode) {
        this.picusercode = picusercode;
    }

}
