/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author d.manikandan
 */
public class UserTablePreferences {

    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("reodercolumns")
    @Expose
    private String reodercolumns;

    @SerializedName("usercode")
    @Expose
    String usercode;

    @SerializedName("moduleid")
    @Expose
    String moduleid;

    @SerializedName("tableid")
    @Expose
    String tableid;

    @SerializedName("preferredwidth")
    @Expose
    String preferredwidth;

    @SerializedName("preferredcolumn")
    @Expose
    String preferredcolumn;

    @SerializedName("cruser")
    @Expose
    String cruser;

    @SerializedName("crdate")
    @Expose
    String crdate;

    @SerializedName("upduser")
    @Expose
    String upduser;

    @SerializedName("upddate")
    @Expose
    String upddate;

    @SerializedName("rowscount")
    @Expose
    private int rowscount;

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid;
    }

    public String getTableid() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid = tableid;
    }

    public String getPreferredwidth() {
        return preferredwidth;
    }

    public void setPreferredwidth(String preferredwidth) {
        this.preferredwidth = preferredwidth;
    }

    public String getPreferredcolumn() {
        return preferredcolumn;
    }

    public void setPreferredcolumn(String preferredcolumn) {
        this.preferredcolumn = preferredcolumn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUpddate() {
        return upddate;
    }

    public void setUpddate(String upddate) {
        this.upddate = upddate;
    }

    public int getRowscount() {
        return rowscount;
    }

    public void setRowscount(int rowscount) {
        this.rowscount = rowscount;
    }

    public String getReodercolumns() {
        return reodercolumns;
    }

    public void setReodercolumns(String reodercolumns) {
        this.reodercolumns = reodercolumns;
    }
    
    

}
