/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.model;

import com.svm.lrp.bpm.nfr.bpm.vo.TaskSummaryVo;
import com.svm.lrp.bpm.util.vo.StatusVo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author d.manikandan
 */
public class LandingDataVo implements Serializable {

    List data; 
    //
    String referenceNumber; // M
    LandingAction action;  // M
    //
    TaskSummaryVo tasksummary; // M
    
    String wfid // backend;
    //
    String bpmwfid  // backend;;
    //
    String syncstatus;
    //
    boolean isBPMEnabled = false; // Module Structure
    
    boolean createWFHistory = false;
    
    boolean isDynamicMdl = false;
    //
    private StatusVo.STATUS status;
    
    String taskid = "";
    
    boolean thirdvalidationstatus;
    
    String selectedvessel;

    //Super edit NFR-1981
    boolean superEditor;
    boolean powerEditor;
    String powerEditorType;

    public String getSelectedvessel() {
        return selectedvessel;
    }

    public void setSelectedvessel(String selectedvessel) {
        this.selectedvessel = selectedvessel;
    }

    public boolean isIsDynamicMdl() {
        return isDynamicMdl;
    }

    public void setIsDynamicMdl(boolean isDynamicMdl) {
        this.isDynamicMdl = isDynamicMdl;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public LandingAction getAction() {
        return action;
    }

    public void setAction(LandingAction action) {
        this.action = action;
    }

    public TaskSummaryVo getTasksummary() {
        return tasksummary;
    }

    public void setTasksummary(TaskSummaryVo tasksummary) {
        this.tasksummary = tasksummary;
    }

    public enum LandingAction {

        EDIT, DELETE, NEW, VIEW, NAVIGATEVIEW, NAVIGATEEDIT, NAVIGATENEW
    }

    public String getWfid() {
        return wfid;
    }

    public void setWfid(String wfid) {
        this.wfid = wfid;
    }

    public boolean isIsBPMEnabled() {
        return isBPMEnabled;
    }

    public void setIsBPMEnabled(boolean isBPMEnabled) {
        this.isBPMEnabled = isBPMEnabled;
    }

    public boolean isCreateWFHistory() {
        return createWFHistory;
    }

    public void setCreateWFHistory(boolean createWFHistory) {
        this.createWFHistory = createWFHistory;
    }

    public String getBpmwfid() {
        return bpmwfid;
    }

    public void setBpmwfid(String bpmwfid) {
        this.bpmwfid = bpmwfid;
    }

    public StatusVo.STATUS getStatus() {
        return status;
    }

    public void setStatus(StatusVo.STATUS status) {
        this.status = status;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getSyncstatus() {
        return syncstatus;
    }

    public void setSyncstatus(String syncstatus) {
        this.syncstatus = syncstatus;
    }

    public boolean isThirdvalidationstatus() {
        return thirdvalidationstatus;
    }

    public void setThirdvalidationstatus(boolean thirdvalidationstatus) {
        this.thirdvalidationstatus = thirdvalidationstatus;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public boolean isSuperEditor() {
        return superEditor;
    }

    public void setSuperEditor(boolean superEditor) {
        this.superEditor = superEditor;
    }

    public boolean isPowerEditor() {
        return powerEditor;
    }

    public void setPowerEditor(boolean powerEditor) {
        this.powerEditor = powerEditor;
    }

    public String getPowerEditorType() {
        return powerEditorType;
    }

    public void setPowerEditorType(String powerEditorType) {
        this.powerEditorType = powerEditorType;
    }

}
