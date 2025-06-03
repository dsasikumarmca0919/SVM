/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

/**
 *
 * @author salomi.a
 */
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dynamiclandingpage implements Serializable {

    @SerializedName("viewservicename")
    @Expose
    private String viewservicename;

    @SerializedName("viewinput")
    @Expose
    private String viewinput;

    @SerializedName("deleteinput")
    @Expose
    private String deleteinput;

    @SerializedName("columnmetadata")
    @Expose
    private String columnmetadata;

    @SerializedName("allowdelete")
    @Expose
    private String allowdelete;

    @SerializedName("deleteidentifier")
    @Expose
    private String deleteidentifier;

    @SerializedName("viewidentifier")
    @Expose
    private String viewidentifier;

    @SerializedName("viewtype")
    @Expose
    private String viewtype;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("deleteservice")
    @Expose
    private String deleteservice;

    @SerializedName("mdlid")
    @Expose
    private String mdlid;

    @SerializedName("filterdefinition")
    @Expose
    private String filterdefinition;

    @SerializedName("actiondefinition")
    @Expose
    private String actiondefinition;

    @SerializedName("thirdlevelvalidation")
    @Expose
    private String thirdlevelvalidation;

    @SerializedName("thirdlevelservicename")
    @Expose
    private String thirdlevelservicename;

    @SerializedName("applyhandlebyuserlogic")
    @Expose
    private String applyhandlebyuserlogic;

    @SerializedName("statusnottocheckhandlelogic")
    @Expose
    private String statusnottocheckhandlelogic;

     @SerializedName("daterangeindays")
    @Expose
    private int daterangeindays;

    public int getDaterangeindays() {
        return daterangeindays;
    }

    public void setDaterangeindays(int daterangeindays) {
        this.daterangeindays = daterangeindays;
    }
    public String getViewservicename() {
        return viewservicename;
    }

    public void setViewservicename(String viewservicename) {
        this.viewservicename = viewservicename;
    }

    public String getViewinput() {
        return viewinput;
    }

    public void setViewinput(String viewinput) {
        this.viewinput = viewinput;
    }

    public String getDeleteinput() {
        return deleteinput;
    }

    public void setDeleteinput(String deleteinput) {
        this.deleteinput = deleteinput;
    }

    public String getColumnmetadata() {
        return columnmetadata;
    }

    public void setColumnmetadata(String columnmetadata) {
        this.columnmetadata = columnmetadata;
    }

    public String getAllowdelete() {
        return allowdelete;
    }

    public void setAllowdelete(String allowdelete) {
        this.allowdelete = allowdelete;
    }

    public String getDeleteidentifier() {
        return deleteidentifier;
    }

    public void setDeleteidentifier(String deleteidentifier) {
        this.deleteidentifier = deleteidentifier;
    }

    public String getViewidentifier() {
        return viewidentifier;
    }

    public void setViewidentifier(String viewidentifier) {
        this.viewidentifier = viewidentifier;
    }

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeleteservice() {
        return deleteservice;
    }

    public void setDeleteservice(String deleteservice) {
        this.deleteservice = deleteservice;
    }

    public String getMdlid() {
        return mdlid;
    }

    public void setMdlid(String mdlid) {
        this.mdlid = mdlid;
    }

    @SerializedName("writerights")
    @Expose
    private String writerights;

    @SerializedName("allowedit")
    @Expose
    private String allowedit;

    @SerializedName("allowcreate")
    @Expose
    private String allowcreate;

    public String getWriterights() {
        return writerights;
    }

    public void setWriterights(String writerights) {
        this.writerights = writerights;
    }

    public String getAllowedit() {
        return allowedit;
    }

    public void setAllowedit(String allowedit) {
        this.allowedit = allowedit;
    }

    public String getAllowcreate() {
        return allowcreate;
    }

    public void setAllowcreate(String allowcreate) {
        this.allowcreate = allowcreate;
    }

    public String getFilterdefinition() {
        return filterdefinition;
    }

    public void setFilterdefinition(String filterdefinition) {
        this.filterdefinition = filterdefinition;
    }

    public String getActiondefinition() {
        return actiondefinition;
    }

    public void setActiondefinition(String actiondefinition) {
        this.actiondefinition = actiondefinition;
    }

    public String getThirdlevelvalidation() {
        return thirdlevelvalidation;
    }

    public void setThirdlevelvalidation(String thirdlevelvalidation) {
        this.thirdlevelvalidation = thirdlevelvalidation;
    }

    public String getThirdlevelservicename() {
        return thirdlevelservicename;
    }

    public void setThirdlevelservicename(String thirdlevelservicename) {
        this.thirdlevelservicename = thirdlevelservicename;
    }

    public String getApplyhandlebyuserlogic() {
        return applyhandlebyuserlogic;
    }

    public void setApplyhandlebyuserlogic(String applyhandlebyuserlogic) {
        this.applyhandlebyuserlogic = applyhandlebyuserlogic;
    }

    public String getStatusnottocheckhandlelogic() {
        return statusnottocheckhandlelogic;
    }

    public void setStatusnottocheckhandlelogic(String statusnottocheckhandlelogic) {
        this.statusnottocheckhandlelogic = statusnottocheckhandlelogic;
    }
    
    @SerializedName("statustoshowallusers")
    @Expose
    private String statustoshowallusers;

    public String getStatustoshowallusers() {
        return statustoshowallusers;
    }

    public void setStatustoshowallusers(String statustoshowallusers) {
        this.statustoshowallusers = statustoshowallusers;
    }
    
    @SerializedName("controltypebasedstatus")
    @Expose
    private String controltypebasedstatus;

    public String getControltypebasedstatus() {
        return controltypebasedstatus;
    }

    public void setControltypebasedstatus(String controltypebasedstatus) {
        this.controltypebasedstatus = controltypebasedstatus;
    }
    
    
}
