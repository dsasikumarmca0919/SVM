/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Communicationwindowchat implements Serializable{

	@SerializedName("empname")
	@Expose
	private String empname;

	@SerializedName("formserialid")
	@Expose
	private String formserialid;

	@SerializedName("senderid")
	@Expose
	private String senderid;

	@SerializedName("comchatid")
	@Expose
	private String comchatid;

	@SerializedName("rankcode")
	@Expose
	private String rankcode;

	@SerializedName("formrefno")
	@Expose
	private String formrefno;

	@SerializedName("readstatus")
	@Expose
	private String readstatus;

	@SerializedName("message")
	@Expose
	private String message;

	@SerializedName("createdon")
	@Expose
	private String createdon;


	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getFormserialid() {
		return formserialid;
	}
	public void setFormserialid(String formserialid) {
		this.formserialid = formserialid;
	}
	public String getSenderid() {
		return senderid;
	}
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	public String getComchatid() {
		return comchatid;
	}
	public void setComchatid(String comchatid) {
		this.comchatid = comchatid;
	}
	public String getRankcode() {
		return rankcode;
	}
	public void setRankcode(String rankcode) {
		this.rankcode = rankcode;
	}
	public String getFormrefno() {
		return formrefno;
	}
	public void setFormrefno(String formrefno) {
		this.formrefno = formrefno;
	}
	public String getReadstatus() {
		return readstatus;
	}
	public void setReadstatus(String readstatus) {
		this.readstatus = readstatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}

}
