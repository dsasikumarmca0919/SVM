/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author durgadevi.b
 */
public class SingleChoiceRadioVo {
    private String fieldsetval;
    private String selectedradiobtn;
    private ArrayList radioallitems;
    private ArrayList multichoiceval;
    private Date fromdate;
    private String opvaluedate;
    

    public String getFieldsetval() {
        return fieldsetval;
    }

    public void setFieldsetval(String fieldsetval) {
        this.fieldsetval = fieldsetval;
    }

    public String getSelectedradiobtn() {
        return selectedradiobtn;
    }

    public void setSelectedradiobtn(String selectedradiobtn) {
        this.selectedradiobtn = selectedradiobtn;
    }

    public ArrayList getRadioallitems() {
        return radioallitems;
    }

    public void setRadioallitems(ArrayList radioallitems) {
        this.radioallitems = radioallitems;
    }

    public ArrayList getMultichoiceval() {
        return multichoiceval;
    }

    public void setMultichoiceval(ArrayList multichoiceval) {
        this.multichoiceval = multichoiceval;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public String getOpvaluedate() {
        return opvaluedate;
    }

    public void setOpvaluedate(String opvaluedate) {
        this.opvaluedate = opvaluedate;
    }
    
    
}

