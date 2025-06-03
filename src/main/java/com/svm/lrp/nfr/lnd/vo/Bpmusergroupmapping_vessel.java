/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author naveenkumar.sakthi
 */
public class Bpmusergroupmapping_vessel {

    @SerializedName("roltype")
    @Expose
    private String roltype;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("vslcompcode")
    @Expose
    private String vslcompcode;

    @SerializedName("usercode")
    @Expose
    private String usercode;

    @SerializedName("groupcode")
    @Expose
    private String groupcode;

    @SerializedName("username")
    @Expose
    private String username;

    public String getRoltype() {
        return roltype;
    }

    public void setRoltype(String roltype) {
        this.roltype = roltype;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getVslcompcode() {
        return vslcompcode;
    }

    public void setVslcompcode(String vslcompcode) {
        this.vslcompcode = vslcompcode;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
