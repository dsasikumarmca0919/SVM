/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WidgetVo implements Serializable {

    private String wvalue;
    private int count;
    private boolean filterbool;
     private String strclass;
        private String title;
 private String wColumnname;
private String tooltip;

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getwColumnname() {
        return wColumnname;
    }

    public void setwColumnname(String wColumnname) {
        this.wColumnname = wColumnname;
    }
 
 
    public String getStrclass() {
        return strclass;
    }

    public void setStrclass(String strclass) {
        this.strclass = strclass;
    }

    public String getWvalue() {
        return wvalue;
    }

    public void setWvalue(String wvalue) {
        this.wvalue = wvalue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isFilterbool() {
        return filterbool;
    }

    public void setFilterbool(boolean filterbool) {
        this.filterbool = filterbool;
    }
   
}
