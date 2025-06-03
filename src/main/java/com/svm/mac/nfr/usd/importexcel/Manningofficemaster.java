/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.mac.nfr.usd.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author d.manikandan
 */
public class Manningofficemaster implements Serializable {

    @SerializedName("mannoffcode")
    @Expose
    private String mannoffcode;

    @SerializedName("mannoffdesc")
    @Expose
    private String mannoffdesc;

    @SerializedName("id")
    @Expose
    private int id;

    public String getMannoffcode() {
        return mannoffcode;
    }

    public void setMannoffcode(String mannoffcode) {
        this.mannoffcode = mannoffcode;
    }

    public String getMannoffdesc() {
        return mannoffdesc;
    }

    public void setMannoffdesc(String mannoffdesc) {
        this.mannoffdesc = mannoffdesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
