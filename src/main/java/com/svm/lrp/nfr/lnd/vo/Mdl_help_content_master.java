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
public class Mdl_help_content_master {

    @SerializedName("upddate")
    @Expose
    private String upddate;

    @SerializedName("active_status")
    @Expose
    private String active_status;

    @SerializedName("subtnt")
    @Expose
    private int subtnt;

    @SerializedName("cruser")
    @Expose
    private String cruser;

    @SerializedName("crdate")
    @Expose
    private String crdate;

    @SerializedName("hlpid")
    @Expose
    private String hlpid;

    @SerializedName("tnt")
    @Expose
    private int tnt;

    @SerializedName("upduser")
    @Expose
    private String upduser;

    @SerializedName("mdlcode")
    @Expose
    private String mdlcode;

    @SerializedName("users")
    @Expose
    private String users;

    @SerializedName("grouplist")
    @Expose
    private String grouplist;

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

    public int getSubtnt() {
        return subtnt;
    }

    public void setSubtnt(int subtnt) {
        this.subtnt = subtnt;
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

    public String getHlpid() {
        return hlpid;
    }

    public void setHlpid(String hlpid) {
        this.hlpid = hlpid;
    }

    public int getTnt() {
        return tnt;
    }

    public void setTnt(int tnt) {
        this.tnt = tnt;
    }

    public String getUpduser() {
        return upduser;
    }

    public void setUpduser(String upduser) {
        this.upduser = upduser;
    }

    public String getMdlcode() {
        return mdlcode;
    }

    public void setMdlcode(String mdlcode) {
        this.mdlcode = mdlcode;
    }

    @SerializedName("rankcode")
    @Expose
    private String rankcode;

    @SerializedName("shorecode")
    @Expose
    private String shorecode;

    @SerializedName("location")
    @Expose
    private String location;

    @SerializedName("usercode")
    @Expose
    private String usercode;

    @SerializedName("groupcode")
    @Expose
    private String groupcode;

    public String getRankcode() {
        return rankcode;
    }

    public void setRankcode(String rankcode) {
        this.rankcode = rankcode;
    }

    public String getShorecode() {
        return shorecode;
    }

    public void setShorecode(String shorecode) {
        this.shorecode = shorecode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getGrouplist() {
        return grouplist;
    }

    public void setGrouplist(String grouplist) {
        this.grouplist = grouplist;
    }

}
