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
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.svm.mac.nfr.usd.importexcel.Countrymaster;
import com.svm.mac.nfr.usd.importexcel.Manningofficemaster;
import com.svm.mac.nfr.usd.importexcel.Shoremaster;
import com.svm.mac.nfr.usd.importexcel.UserDetail;
import com.svm.mac.nfr.usd.importexcel.UserTypeMaster;
import com.svm.mac.nfr.usd.importexcel.rankmaster;
import com.svm.mac.wfa.model.entity.Workflowhistory;
import com.svm.mac.wfa.model.entity.Workflowsleepmsg;
import com.svm.mac.atc.model.entity.Dynamiclandingpage;
//import com.svm.mac.mas.bpm.model.entity.Workflowmapping;

//import com.svm.mac.mas.bpm.model.entity.Workflowmapping;
public class CompleteModel implements Serializable {

    @SerializedName("userdetail")
    @Expose
    private List<UserDetail> userDetail = new ArrayList<UserDetail>();

   @SerializedName("dynamiclandingpage")
   @Expose
   public List<Dynamiclandingpage> dynamiclandingpage = new ArrayList<>();

    @SerializedName("usertablepreferences")
    @Expose
    private List<UserTablePreferences> userTablePreferences = new ArrayList<UserTablePreferences>();

    @SerializedName("workflowmapping")
    @Expose
    private List<Workflowmapping> workflowmapping = new ArrayList<Workflowmapping>();

//    @SerializedName("wk_formwkmapping_temp")
//    @Expose
//    private List<Wk_formwkmapping> wk_formwkmapping = new ArrayList<Wk_formwkmapping>();
    @SerializedName("shoremaster")
    @Expose
    private List<Shoremaster> shoreMaster = new ArrayList<Shoremaster>();

    @SerializedName("usertypemaster")
    @Expose
    private List<UserTypeMaster> usertypemaster = new ArrayList<UserTypeMaster>();

    @SerializedName("manningofficemaster")
    @Expose
    private List<Manningofficemaster> manningofficemaster = new ArrayList<Manningofficemaster>();

    @SerializedName("countrymaster")
    @Expose
    private List<Countrymaster> countrymaster = new ArrayList<Countrymaster>();

    @SerializedName("rankmaster")
    @Expose
    private List<rankmaster> rankmaster = new ArrayList<rankmaster>();

    @SerializedName("rskmaster")
    @Expose
    private List<Rskmaster> rskmaster = new ArrayList<Rskmaster>();

    @SerializedName("vesselmapping")
    @Expose
    private List<Vesselmapping> vesselmapping = new ArrayList<Vesselmapping>();

    //
    @SerializedName("uvs_userdetail")
    @Expose
    private List<Uvs_userdetail> userdetail = new ArrayList<Uvs_userdetail>();

    @SerializedName("communicationwindowchat")
    @Expose
    private List<Communicationwindowchat> communicationwindowchat = new ArrayList<Communicationwindowchat>();

    @SerializedName("notificationhistory")
    @Expose
    private List<Notificationhistory> notificationhistory = new ArrayList<Notificationhistory>();
    @SerializedName("vesselmaster")
    @Expose
    private List<Vesselmaster> vesselmaster = new ArrayList<Vesselmaster>();

    @SerializedName("bpmgroupmaster")
    @Expose
    private List<Bpmgroupmaster> bpmgroupmaster = new ArrayList<Bpmgroupmaster>();
    @SerializedName("modulestructure")
    @Expose
    private List<Modulestructure> modulestructure = new ArrayList<Modulestructure>();
    @SerializedName("systemconfig")
    @Expose
    private List<Systemconfig> systemconfig = new ArrayList<Systemconfig>();
    @SerializedName("pictask")
    @Expose
    private List<Pictask> pictask = new ArrayList<Pictask>();
    @SerializedName("deleterequest")
    @Expose
    private List<Deleterequest> deleterequest = new ArrayList<Deleterequest>();
    @SerializedName("mdl_super_user")
    @Expose
    private List<Mdl_super_user> mdl_super_user = new ArrayList<Mdl_super_user>();
    
    @SerializedName("rs")
    @Expose
    private RsModel rs;

    public RsModel getRs() {
        return this.rs;
    }

    public void setRs(RsModel rs) {
        this.rs = rs;
    }
    public List<Deleterequest> getDeleterequest() {
        return deleterequest;
    }

    public void setDeleterequest(List<Deleterequest> deleterequest) {
        this.deleterequest = deleterequest;
    }

    public List<Pictask> getPictask() {
        return pictask;
    }

    public void setPictask(List<Pictask> pictask) {
        this.pictask = pictask;
    }

    public List<Systemconfig> getSystemconfig() {
        return systemconfig;
    }

    public void setSystemconfig(List<Systemconfig> systemconfig) {
        this.systemconfig = systemconfig;
    }

    public List<Modulestructure> getModulestructure() {
        return modulestructure;
    }

    public void setModulestructure(List<Modulestructure> modulestructure) {
        this.modulestructure = modulestructure;
    }

    public List<Bpmgroupmaster> getBpmgroupmaster() {
        return bpmgroupmaster;
    }

    public void setBpmgroupmaster(List<Bpmgroupmaster> bpmgroupmaster) {
        this.bpmgroupmaster = bpmgroupmaster;
    }

    public List<Notificationhistory> getNotificationhistory() {
        return notificationhistory;
    }

    public void setNotificationhistory(List<Notificationhistory> notificationhistory) {
        this.notificationhistory = notificationhistory;
    }

    public List<Communicationwindowchat> getCommunicationwindowchat() {
        return communicationwindowchat;
    }

    public void setCommunicationwindowchat(List<Communicationwindowchat> communicationwindowchat) {
        this.communicationwindowchat = communicationwindowchat;
    }

    public List<Uvs_userdetail> getUserdetail() {
        return userdetail;
    }

    public void setUserdetail(List<Uvs_userdetail> userdetail) {
        this.userdetail = userdetail;
    }

    //
    public List<Rskmaster> getRskmaster() {
        return rskmaster;
    }

    public void setRskmaster(List<Rskmaster> rskmaster) {
        this.rskmaster = rskmaster;
    }

    public List<rankmaster> getRankmaster() {
        return rankmaster;
    }

    public void setRankmaster(List<rankmaster> rankmaster) {
        this.rankmaster = rankmaster;
    }

    public List<Shoremaster> getShoreMaster() {
        return shoreMaster;
    }

    public void setShoreMaster(List<Shoremaster> shoreMaster) {
        this.shoreMaster = shoreMaster;
    }

    public List<UserTypeMaster> getUsertypemaster() {
        return usertypemaster;
    }

    public void setUsertypemaster(List<UserTypeMaster> usertypemaster) {
        this.usertypemaster = usertypemaster;
    }

    public List<Manningofficemaster> getManningofficemaster() {
        return manningofficemaster;
    }

    public void setManningofficemaster(List<Manningofficemaster> manningofficemaster) {
        this.manningofficemaster = manningofficemaster;
    }

    public List<Countrymaster> getCountrymaster() {
        return countrymaster;
    }

    public void setCountrymaster(List<Countrymaster> countrymaster) {
        this.countrymaster = countrymaster;
    }

    public List<Workflowmapping> getWorkflowmapping() {
        return workflowmapping;
    }

    public void setWorkflowmapping(List<Workflowmapping> workflowmapping) {
        this.workflowmapping = workflowmapping;
    }

    public List<UserTablePreferences> getUserTablePreferences() {
        return userTablePreferences;
    }

    public void setUserTablePreferences(List<UserTablePreferences> userTablePreferences) {
        this.userTablePreferences = userTablePreferences;
    }

    public List<Dynamiclandingpage> getDynamiclandingpage() {
        return dynamiclandingpage;
    }

    public void setDynamiclandingpage(List<Dynamiclandingpage> dynamiclandingpage) {
        this.dynamiclandingpage = dynamiclandingpage;
    }

   
    public List<UserDetail> getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(List<UserDetail> userDetail) {
        this.userDetail = userDetail;
    }

    public List<Vesselmapping> getVesselmapping() {
        return vesselmapping;
    }

    public void setVesselmapping(List<Vesselmapping> vesselmapping) {
        this.vesselmapping = vesselmapping;
    }
    @SerializedName("workflowhistory")
    @Expose
    private List<Workflowhistory> workflowhistory = new ArrayList<Workflowhistory>();

    public List<Workflowhistory> getWorkflowhistory() {
        return workflowhistory;
    }

    public void setWorkflowhistory(List<Workflowhistory> workflowhistory) {
        this.workflowhistory = workflowhistory;
    }
    @SerializedName("processinstancemaster")
    @Expose
    private List<Processinstancemaster> processinstancemaster = new ArrayList<Processinstancemaster>();

    public List<Processinstancemaster> getProcessinstancemaster() {
        return processinstancemaster;
    }

    public void setProcessinstancemaster(List<Processinstancemaster> processinstancemaster) {
        this.processinstancemaster = processinstancemaster;
    }

    public List<Vesselmaster> getVesselmaster() {
        return vesselmaster;
    }

    public void setVesselmaster(List<Vesselmaster> vesselmaster) {
        this.vesselmaster = vesselmaster;
    }

    public List<Mdl_super_user> getMdl_super_user() {
        return mdl_super_user;
    }

    public void setMdl_super_user(List<Mdl_super_user> mdl_super_user) {
        this.mdl_super_user = mdl_super_user;
    }
    
    @SerializedName("mdl_help_content_master")
    @Expose
    private List<Mdl_help_content_master> mdl_help_content_master = new ArrayList<Mdl_help_content_master>();

    public List<Mdl_help_content_master> getMdl_help_content_master() {
        return mdl_help_content_master;
    }

    public void setMdl_help_content_master(List<Mdl_help_content_master> mdl_help_content_master) {
        this.mdl_help_content_master = mdl_help_content_master;
    }

    @SerializedName("mdl_power_edit_user_group")
    @Expose
    private List<Mdl_power_edit_user_group> mdl_power_edit_user_group = new ArrayList<Mdl_power_edit_user_group>();

    public List<Mdl_power_edit_user_group> getMdl_power_edit_user_group() {
        return mdl_power_edit_user_group;
    }

    public void setMdl_power_edit_user_group(List<Mdl_power_edit_user_group> mdl_power_edit_user_group) {
        this.mdl_power_edit_user_group = mdl_power_edit_user_group;
    }

    @SerializedName("wk_bpmstagemapping")
    @Expose
    private List<com.svm.mac.wfa.model.entity.Workflownextuser> wk_bpmstagemapping = new ArrayList<com.svm.mac.wfa.model.entity.Workflownextuser>();

    public List<com.svm.mac.wfa.model.entity.Workflownextuser> getWk_bpmstagemapping() {
        return wk_bpmstagemapping;
    }

    public void setWk_bpmstagemapping(List<com.svm.mac.wfa.model.entity.Workflownextuser> wk_bpmstagemapping) {
        this.wk_bpmstagemapping = wk_bpmstagemapping;
    }

    @SerializedName("bpmusergroupmapping")
    @Expose
    private List<Bpmusergroupmapping> bpmusergroupmapping = new ArrayList<Bpmusergroupmapping>();

    public List<Bpmusergroupmapping> getBpmusergroupmapping() {
        return bpmusergroupmapping;
    }

    public void setBpmusergroupmapping(List<Bpmusergroupmapping> bpmusergroupmapping) {
        this.bpmusergroupmapping = bpmusergroupmapping;
    }

    @SerializedName("bpmusergroupmapping_vessel")
    @Expose
    private List<Bpmusergroupmapping_vessel> bpmusergroupmapping_vessel = new ArrayList<Bpmusergroupmapping_vessel>();

    public List<Bpmusergroupmapping_vessel> getBpmusergroupmapping_vessel() {
        return bpmusergroupmapping_vessel;
    }

    public void setBpmusergroupmapping_vessel(List<Bpmusergroupmapping_vessel> bpmusergroupmapping_vessel) {
        this.bpmusergroupmapping_vessel = bpmusergroupmapping_vessel;
    }
    @SerializedName("workflowsleepmsg")
    @Expose
    private List<Workflowsleepmsg> workflowsleepmsg = new ArrayList<Workflowsleepmsg>();

    public List<Workflowsleepmsg> getWorkflowsleepmsg() {
        return workflowsleepmsg;
    }

    public void setWorkflowsleepmsg(List<Workflowsleepmsg> workflowsleepmsg) {
        this.workflowsleepmsg = workflowsleepmsg;
    }
    
    @SerializedName("workflownextuser")
    @Expose
    private List<com.svm.mac.wfa.model.entity.Workflownextuser> workflownextuser = new ArrayList<com.svm.mac.wfa.model.entity.Workflownextuser>();

    public List<com.svm.mac.wfa.model.entity.Workflownextuser> getWorkflownextuser() {
        return workflownextuser;
    }

    public void setWorkflownextuser(List<com.svm.mac.wfa.model.entity.Workflownextuser> workflownextuser) {
        this.workflownextuser = workflownextuser;
    }
    
    
}
