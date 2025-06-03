/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author naveenkumar.sakthi
 */
public class Mdl_power_edit_user_group implements Serializable{

	@SerializedName("shorecode")
	@Expose
	private String shorecode;

	@SerializedName("hlpid")
	@Expose
	private String hlpid;

	@SerializedName("groupcode")
	@Expose
	private String groupcode;

	@SerializedName("mdlcode")
	@Expose
	private String mdlcode;

	@SerializedName("users")
	@Expose
	private String users;

	@SerializedName("attributeid")
	@Expose
	private String attributeid;

	@SerializedName("fieldname")
	@Expose
	private String fieldname;

	@SerializedName("upddate")
	@Expose
	private String upddate;

	@SerializedName("rankcode")
	@Expose
	private String rankcode;

	@SerializedName("cruser")
	@Expose
	private String cruser;

	@SerializedName("applicablefields")
	@Expose
	private String applicablefields;

	@SerializedName("crdate")
	@Expose
	private String crdate;

	@SerializedName("issystemgenerated")
	@Expose
	private String issystemgenerated;

	@SerializedName("location")
	@Expose
	private String location;

	@SerializedName("grouplist")
	@Expose
	private String grouplist;

	@SerializedName("id")
	@Expose
	private int id;

	@SerializedName("upduser")
	@Expose
	private String upduser;

	@SerializedName("usercode")
	@Expose
	private String usercode;

	@SerializedName("status")
	@Expose
	private String status;


	public String getShorecode() {
		return shorecode;
	}
	public void setShorecode(String shorecode) {
		this.shorecode = shorecode;
	}
	public String getHlpid() {
		return hlpid;
	}
	public void setHlpid(String hlpid) {
		this.hlpid = hlpid;
	}
	public String getGroupcode() {
		return groupcode;
	}
	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}
	public String getMdlcode() {
		return mdlcode;
	}
	public void setMdlcode(String mdlcode) {
		this.mdlcode = mdlcode;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getAttributeid() {
		return attributeid;
	}
	public void setAttributeid(String attributeid) {
		this.attributeid = attributeid;
	}
	public String getFieldname() {
		return fieldname;
	}
	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}
	public String getUpddate() {
		return upddate;
	}
	public void setUpddate(String upddate) {
		this.upddate = upddate;
	}
	public String getRankcode() {
		return rankcode;
	}
	public void setRankcode(String rankcode) {
		this.rankcode = rankcode;
	}
	public String getCruser() {
		return cruser;
	}
	public void setCruser(String cruser) {
		this.cruser = cruser;
	}
	public String getApplicablefields() {
		return applicablefields;
	}
	public void setApplicablefields(String applicablefields) {
		this.applicablefields = applicablefields;
	}
	public String getCrdate() {
		return crdate;
	}
	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}
	public String getIssystemgenerated() {
		return issystemgenerated;
	}
	public void setIssystemgenerated(String issystemgenerated) {
		this.issystemgenerated = issystemgenerated;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGrouplist() {
		return grouplist;
	}
	public void setGrouplist(String grouplist) {
		this.grouplist = grouplist;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUpduser() {
		return upduser;
	}
	public void setUpduser(String upduser) {
		this.upduser = upduser;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
