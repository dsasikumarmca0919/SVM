/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

/**
 *
 * @author durgadevi.b
 */
import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rskmaster implements Serializable{

	@SerializedName("wrkflowid")
	@Expose
	private String wrkflowid;


	public String getWrkflowid() {
		return wrkflowid;
	}
	public void setWrkflowid(String wrkflowid) {
		this.wrkflowid = wrkflowid;
	}

}