/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notificationhistory implements Serializable{

	@SerializedName("notifydate")
	@Expose
	private String notifydate;

	@SerializedName("refno")
	@Expose
	private String refno;

	@SerializedName("menuname")
	@Expose
	private String menuname;

	@SerializedName("vesselcode")
	@Expose
	private String vesselcode;

	@SerializedName("notifyevent")
	@Expose
	private String notifyevent;

	@SerializedName("prioritycode")
	@Expose
	private String prioritycode;

	@SerializedName("notifyfrom")
	@Expose
	private String notifyfrom;

	@SerializedName("readstatus")
	@Expose
	private String readstatus;

	@SerializedName("notifydesc")
	@Expose
	private String notifydesc;

	@SerializedName("vesselname")
	@Expose
	private String vesselname;

	@SerializedName("mdlcode")
	@Expose
	private String mdlcode;

	@SerializedName("priorityname")
	@Expose
	private String priorityname;

	@SerializedName("payload")
	@Expose
	private String payload;

	@SerializedName("readdate")
	@Expose
	private String readdate;

	@SerializedName("cntypecode")
	@Expose
	private String cntypecode;

	@SerializedName("notifyhistoryid")
	@Expose
	private String notifyhistoryid;

	@SerializedName("notifyto")
	@Expose
	private String notifyto;

	@SerializedName("usercode")
	@Expose
	private String usercode;

	@SerializedName("ismyvessel")
	@Expose
	private String ismyvessel;


	public String getNotifydate() {
		return notifydate;
	}
	public void setNotifydate(String notifydate) {
		this.notifydate = notifydate;
	}
	public String getRefno() {
		return refno;
	}
	public void setRefno(String refno) {
		this.refno = refno;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getVesselcode() {
		return vesselcode;
	}
	public void setVesselcode(String vesselcode) {
		this.vesselcode = vesselcode;
	}
	public String getNotifyevent() {
		return notifyevent;
	}
	public void setNotifyevent(String notifyevent) {
		this.notifyevent = notifyevent;
	}
	public String getPrioritycode() {
		return prioritycode;
	}
	public void setPrioritycode(String prioritycode) {
		this.prioritycode = prioritycode;
	}
	public String getNotifyfrom() {
		return notifyfrom;
	}
	public void setNotifyfrom(String notifyfrom) {
		this.notifyfrom = notifyfrom;
	}
	public String getReadstatus() {
		return readstatus;
	}
	public void setReadstatus(String readstatus) {
		this.readstatus = readstatus;
	}
	public String getNotifydesc() {
		return notifydesc;
	}
	public void setNotifydesc(String notifydesc) {
		this.notifydesc = notifydesc;
	}
	public String getVesselname() {
		return vesselname;
	}
	public void setVesselname(String vesselname) {
		this.vesselname = vesselname;
	}
	public String getMdlcode() {
		return mdlcode;
	}
	public void setMdlcode(String mdlcode) {
		this.mdlcode = mdlcode;
	}
	public String getPriorityname() {
		return priorityname;
	}
	public void setPriorityname(String priorityname) {
		this.priorityname = priorityname;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getReaddate() {
		return readdate;
	}
	public void setReaddate(String readdate) {
		this.readdate = readdate;
	}
	public String getCntypecode() {
		return cntypecode;
	}
	public void setCntypecode(String cntypecode) {
		this.cntypecode = cntypecode;
	}
	public String getNotifyhistoryid() {
		return notifyhistoryid;
	}
	public void setNotifyhistoryid(String notifyhistoryid) {
		this.notifyhistoryid = notifyhistoryid;
	}
	public String getNotifyto() {
		return notifyto;
	}
	public void setNotifyto(String notifyto) {
		this.notifyto = notifyto;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getIsmyvessel() {
		return ismyvessel;
	}
	public void setIsmyvessel(String ismyvessel) {
		this.ismyvessel = ismyvessel;
	}

}
