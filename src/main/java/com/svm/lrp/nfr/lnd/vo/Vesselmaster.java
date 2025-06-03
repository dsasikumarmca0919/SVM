/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vesselmaster implements Serializable{

	@SerializedName("vesselcode")
	@Expose
	private String vesselcode;

	@SerializedName("vesselname")
	@Expose
	private String vesselname;


	public String getVesselcode() {
		return vesselcode;
	}
	public void setVesselcode(String vesselcode) {
		this.vesselcode = vesselcode;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}

}