/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author salomi.a
 */
public class LandingPageVo implements Serializable{
    
    private String mdlid;
    private String title;
    private String viewtype;
    private String viewservicename;
    private String viewidentifier;
    private String allowdelete;
    private String viewinput;
    private String deleteservice;
    private String deleteidentifier;
    private String deleteinput;
    private String columnmetadata;

    public String getMdlid() {
        return mdlid;
    }

    public void setMdlid(String mdlid) {
        this.mdlid = mdlid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewtype() {
        return viewtype;
    }

    public void setViewtype(String viewtype) {
        this.viewtype = viewtype;
    }

    public String getViewservicename() {
        return viewservicename;
    }

    public void setViewservicename(String viewservicename) {
        this.viewservicename = viewservicename;
    }

    public String getViewidentifier() {
        return viewidentifier;
    }

    public void setViewidentifier(String viewidentifier) {
        this.viewidentifier = viewidentifier;
    }

    public String getAllowdelete() {
        return allowdelete;
    }

    public void setAllowdelete(String allowdelete) {
        this.allowdelete = allowdelete;
    }

    public String getViewinput() {
        return viewinput;
    }

    public void setViewinput(String viewinput) {
        this.viewinput = viewinput;
    }

    public String getDeleteservice() {
        return deleteservice;
    }

    public void setDeleteservice(String deleteservice) {
        this.deleteservice = deleteservice;
    }

    public String getDeleteidentifier() {
        return deleteidentifier;
    }

    public void setDeleteidentifier(String deleteidentifier) {
        this.deleteidentifier = deleteidentifier;
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
    
    
    
}
