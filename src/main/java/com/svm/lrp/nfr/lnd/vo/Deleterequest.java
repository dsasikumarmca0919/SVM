/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Deleterequest implements Serializable {

    @SerializedName("empname")
    @Expose
    private String empname;

    @SerializedName("surname")
    @Expose
    private String surname;

    @SerializedName("rankname")
    @Expose
    private String rankname;

    @SerializedName("depname")
    @Expose
    private String depname;

    @SerializedName("mdlrefno")
    @Expose
    private String mdlrefno;

    @SerializedName("reqdate")
    @Expose
    private String reqdate;

    public String getReqdate() {
        return reqdate;
    }

    public void setReqdate(String reqdate) {
        this.reqdate = reqdate;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getMdlrefno() {
        return mdlrefno;
    }

    public void setMdlrefno(String mdlrefno) {
        this.mdlrefno = mdlrefno;
    }

}
