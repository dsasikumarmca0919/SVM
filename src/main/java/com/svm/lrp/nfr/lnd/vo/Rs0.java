/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Rahul.Thennarasu
 */


public class Rs0 {
    @SerializedName("tmpfinal.wfid")
    @Expose
    String wfid;

    @SerializedName("tmpfinal.taskid")
    @Expose
    int taskid;

    @SerializedName("tmpfinal.instanceid")
    @Expose
    String instanceid;

    @SerializedName("tmpfinal.nodeid")
    @Expose
    String nodeid;

    @SerializedName("tmpfinal.status")
    @Expose
    String status;

    @SerializedName("tmpfinal.isclaimed")
    @Expose
    String isclaimed;

    @SerializedName("tmpfinal.claimuser")
    @Expose
    String claimuser;

    @SerializedName("tmpfinal.claimdate")
    @Expose
    String claimdate;

    @SerializedName("tmpfinal.usergroup")
    @Expose
    String usergroup;

    @SerializedName("tmpfinal.officecode")
    @Expose
    String officecode;

    @SerializedName("tmpfinal.gateid")
    @Expose
    String gateid;

    @SerializedName("tmpfinal.isreassinged")
    @Expose
    String isreassinged;

    @SerializedName("tmpfinal.claimduration")
    @Expose
    int claimduration;

    @SerializedName("tmpfinal.dueduration")
    @Expose
    int dueduration;

    @SerializedName("tmpfinal.deadlinedate")
    @Expose
    String deadlinedate;

    @SerializedName("tmpfinal.datalogid")
    @Expose
    String datalogid;

    @SerializedName("tmpfinal.remarks")
    @Expose
    String remarks;

    @SerializedName("tmpfinal.disprefno")
    @Expose
    String disprefno;

    @SerializedName("tmpfinal.id")
    @Expose
    int id;

    @SerializedName("tmpfinal.refno")
    @Expose
    String refno;

    @SerializedName("tmpfinal.nodetype")
    @Expose
    String tasktype;

    @SerializedName("tmpfinal.nodename")
    @Expose
    String nodename;

    @SerializedName("tmpfinal.subdate")
    @Expose
    String subdate;

    @SerializedName("tmpfinal.lastmannodeid")
    @Expose
    String lastmannodeid;

    @SerializedName("tmpfinal.lastclaimuser")
    @Expose
    String lastclaimuser;

    @SerializedName("tmpfinal.backTask")
    @Expose
    boolean backTask = false;

    @SerializedName("tmpfinal.code")
    @Expose
    String code;

    @SerializedName("tmpfinal.type")
    @Expose
    String type;

    @SerializedName("tmpfinal.isBackup")
    @Expose
    String isBackup;

    @SerializedName("tmpfinal.backupfor")
    @Expose
    String backupfor;

    @SerializedName("tmpfinal.backupforGroup")
    @Expose
    String backupforGroup;

    @SerializedName("tmpfinal.initiatorid")
    @Expose
    String initiatorid;

    @SerializedName("tmpfinal.formid")
    @Expose
    String formid;

    @SerializedName("tmpfinal.misc")
    @Expose
    String misc;

    @SerializedName("tmpfinal.batchid")
    @Expose
    Integer batchid;

    @SerializedName("tmpfinal.isinviter")
    @Expose
    Integer isinviter;

    @SerializedName("tmpfinal.isinvited")
    @Expose
    Integer isinvited;

    @SerializedName("tmpfinal.isBackTask_Form")
    @Expose
    boolean isBackTask_Form = false;

    @SerializedName("tmpfinal.backupfor_form")
    @Expose
    String backupfor_form;

    @SerializedName("tmpfinal.backupforGroup_form")
    @Expose
    String backupforGroup_form;

    @SerializedName("tmpfinal.ownership")
    @Expose
    String ownership;

    @SerializedName("tmpfinal.transferclaimcontrol")
    @Expose
    String transferclaimcontrol;

    @SerializedName("tmpfinal.superEditor")
    @Expose
    boolean superEditor;

    @SerializedName("tmpfinal.autoRemarks")
    @Expose
    boolean autoRemarks;

    @SerializedName("tmpfinal.flag")
    @Expose
    String flag;

    @SerializedName("tmpfinal.bpmwrkflowid")
	@Expose
	private String bpmwrkflowid;
    
  

    public String getWfid() {
        return wfid;
    }
    public void setWfid(String wfid) {
        this.wfid = wfid;
    }
    public int getTaskid() {
        return taskid;
    }
    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }
    public String getInstanceid() {
        return instanceid;
    }
    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }
    public String getNodeid() {
        return nodeid;
    }
    public void setNodeid(String nodeid) {
        this.nodeid = nodeid;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getIsclaimed() {
        return isclaimed;
    }
    public void setIsclaimed(String isclaimed) {
        this.isclaimed = isclaimed;
    }
    public String getClaimuser() {
        return claimuser;
    }
    public void setClaimuser(String claimuser) {
        this.claimuser = claimuser;
    }
    public String getClaimdate() {
        return claimdate;
    }
    public void setClaimdate(String claimdate) {
        this.claimdate = claimdate;
    }
    public String getUsergroup() {
        return usergroup;
    }
    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }
    public String getOfficecode() {
        return officecode;
    }
    public void setOfficecode(String officecode) {
        this.officecode = officecode;
    }
    public String getGateid() {
        return gateid;
    }
    public void setGateid(String gateid) {
        this.gateid = gateid;
    }
    public String getIsreassinged() {
        return isreassinged;
    }
    public void setIsreassinged(String isreassinged) {
        this.isreassinged = isreassinged;
    }
    public int getClaimduration() {
        return claimduration;
    }
    public void setClaimduration(int claimduration) {
        this.claimduration = claimduration;
    }
    public int getDueduration() {
        return dueduration;
    }
    public void setDueduration(int dueduration) {
        this.dueduration = dueduration;
    }
    public String getDeadlinedate() {
        return deadlinedate;
    }
    public void setDeadlinedate(String deadlinedate) {
        this.deadlinedate = deadlinedate;
    }
    public String getDatalogid() {
        return datalogid;
    }
    public void setDatalogid(String datalogid) {
        this.datalogid = datalogid;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getDisprefno() {
        return disprefno;
    }
    public void setDisprefno(String disprefno) {
        this.disprefno = disprefno;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRefno() {
        return refno;
    }
    public void setRefno(String refno) {
        this.refno = refno;
    }
    public String getTasktype() {
        return tasktype;
    }
    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }
    public String getNodename() {
        return nodename;
    }
    public void setNodename(String nodename) {
        this.nodename = nodename;
    }
    public String getSubdate() {
        return subdate;
    }
    public void setSubdate(String subdate) {
        this.subdate = subdate;
    }
    public String getLastmannodeid() {
        return lastmannodeid;
    }
    public void setLastmannodeid(String lastmannodeid) {
        this.lastmannodeid = lastmannodeid;
    }
    public String getLastclaimuser() {
        return lastclaimuser;
    }
    public void setLastclaimuser(String lastclaimuser) {
        this.lastclaimuser = lastclaimuser;
    }
    public boolean isBackTask() {
        return backTask;
    }
    public void setBackTask(boolean backTask) {
        this.backTask = backTask;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getIsBackup() {
        return isBackup;
    }
    public void setIsBackup(String isBackup) {
        this.isBackup = isBackup;
    }
    public String getBackupfor() {
        return backupfor;
    }
    public void setBackupfor(String backupfor) {
        this.backupfor = backupfor;
    }
    public String getBackupforGroup() {
        return backupforGroup;
    }
    public void setBackupforGroup(String backupforGroup) {
        this.backupforGroup = backupforGroup;
    }
    public String getInitiatorid() {
        return initiatorid;
    }
    public void setInitiatorid(String initiatorid) {
        this.initiatorid = initiatorid;
    }
    public String getFormid() {
        return formid;
    }
    public void setFormid(String formid) {
        this.formid = formid;
    }
    public String getMisc() {
        return misc;
    }
    public void setMisc(String misc) {
        this.misc = misc;
    }
    public Integer getBatchid() {
        return batchid;
    }
    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }
    public Integer getIsinviter() {
        return isinviter;
    }
    public void setIsinviter(Integer isinviter) {
        this.isinviter = isinviter;
    }
    public Integer getIsinvited() {
        return isinvited;
    }
    public void setIsinvited(Integer isinvited) {
        this.isinvited = isinvited;
    }
    public boolean isBackTask_Form() {
        return isBackTask_Form;
    }
    public void setBackTask_Form(boolean isBackTask_Form) {
        this.isBackTask_Form = isBackTask_Form;
    }
    public String getBackupfor_form() {
        return backupfor_form;
    }
    public void setBackupfor_form(String backupfor_form) {
        this.backupfor_form = backupfor_form;
    }
    public String getBackupforGroup_form() {
        return backupforGroup_form;
    }
    public void setBackupforGroup_form(String backupforGroup_form) {
        this.backupforGroup_form = backupforGroup_form;
    }
    public String getOwnership() {
        return ownership;
    }
    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
    public String getTransferclaimcontrol() {
        return transferclaimcontrol;
    }
    public void setTransferclaimcontrol(String transferclaimcontrol) {
        this.transferclaimcontrol = transferclaimcontrol;
    }
    public boolean isSuperEditor() {
        return superEditor;
    }
    public void setSuperEditor(boolean superEditor) {
        this.superEditor = superEditor;
    }
    public boolean isAutoRemarks() {
        return autoRemarks;
    }
    public void setAutoRemarks(boolean autoRemarks) {
        this.autoRemarks = autoRemarks;
    }
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public String getBpmwrkflowid() {
        return bpmwrkflowid;
    }
    public void setBpmwrkflowid(String bpmwrkflowid) {
        this.bpmwrkflowid = bpmwrkflowid;
    }
    
    

    
}
