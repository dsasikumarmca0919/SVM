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
 * @author Rahul.Thennarasu
 */
public class Rs2 {

    @SerializedName("temp_processinstancegroup.taskseqno")
    @Expose
    private int taskseqno;
    @SerializedName("temp_processinstancegroup.instanceid")
    @Expose
    private String instanceid;
    @SerializedName("temp_processinstancegroup.usergroup")
    @Expose
    private String usergroup;
    @SerializedName("temp_processinstancegroup.id")
    @Expose
    private int id;
    @SerializedName("temp_processinstancegroup.nodeid")
    @Expose
    private String nodeid;
    @SerializedName("temp_processinstancegroup.wfid")
    @Expose
    private String wfid;
 
 
    public int getTaskseqno() {
       return this.taskseqno;
    }
 
    public void setTaskseqno(int taskseqno) {
       this.taskseqno = taskseqno;
    }
 
    public String getInstanceid() {
       return this.instanceid;
    }
 
    public void setInstanceid(String instanceid) {
       this.instanceid = instanceid;
    }
 
    public String getUsergroup() {
       return this.usergroup;
    }
 
    public void setUsergroup(String usergroup) {
       this.usergroup = usergroup;
    }
 
    public int getId() {
       return this.id;
    }
 
    public void setId(int id) {
       this.id = id;
    }
 
    public String getNodeid() {
       return this.nodeid;
    }
 
    public void setNodeid(String nodeid) {
       this.nodeid = nodeid;
    }
 
    public String getWfid() {
       return this.wfid;
    }
 
    public void setWfid(String wfid) {
       this.wfid = wfid;
    }



}
