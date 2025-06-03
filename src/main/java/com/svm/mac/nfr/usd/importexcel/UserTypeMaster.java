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
public class UserTypeMaster implements Serializable {

    @SerializedName("usertypedesc")
    @Expose
    private String usertypedesc;

    @SerializedName("usertypecode")
    @Expose
    private String usertypecode;

    @SerializedName("id")
    @Expose
    private int id;

    public String getUsertypedesc() {
        return usertypedesc;
    }

    public void setUsertypedesc(String usertypedesc) {
        this.usertypedesc = usertypedesc;
    }

    public String getUsertypecode() {
        return usertypecode;
    }

    public void setUsertypecode(String usertypecode) {
        this.usertypecode = usertypecode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
