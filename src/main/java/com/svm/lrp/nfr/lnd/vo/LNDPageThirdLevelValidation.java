/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author durgadevi.b
 */
public class LNDPageThirdLevelValidation implements Serializable {

    private String mdlid;
    private String usercode;
    private String cntrltype;
    private ArrayList<Map<String, String>> reflist;
    private ArrayList<Map<String, String>> accesslist;

    public String getMdlid() {
        return mdlid;
    }

    public void setMdlid(String mdlid) {
        this.mdlid = mdlid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getCntrltype() {
        return cntrltype;
    }

    public void setCntrltype(String cntrltype) {
        this.cntrltype = cntrltype;
    }

    public ArrayList getReflist() {
        return reflist;
    }

    public void setReflist(ArrayList reflist) {
        this.reflist = reflist;
    }

    public ArrayList getAccesslist() {
        return accesslist;
    }

    public void setAccesslist(ArrayList accesslist) {
        this.accesslist = accesslist;
    }

}
