/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.lrp.nfr.lnd.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author Rahul.Thennarasu
 */
public class Rs5 {

   @SerializedName("uvs_workflowmapping.bpmwrkflowid")
	@Expose
	private String bpmwrkflowid;

	@SerializedName("uvs_workflowmapping.cnttypecode")
	@Expose
	private String cnttypecode;

	@SerializedName("uvs_workflowmapping.type")
	@Expose
	private String type;

	@SerializedName("uvs_workflowmapping.mdlcode")
	@Expose
	private String mdlcode;

	@SerializedName("uvs_workflowmapping.upddate")
	@Expose
	private String upddate;

	@SerializedName("uvs_workflowmapping.active_status")
	@Expose
	private String active_status;

	@SerializedName("uvs_workflowmapping.isdynamicmdl")
	@Expose
	private String isdynamicmdl;

	@SerializedName("uvs_workflowmapping.cruser")
	@Expose
	private String cruser;

	@SerializedName("uvs_workflowmapping.crdate")
	@Expose
	private String crdate;

	@SerializedName("uvs_workflowmapping.fromcnttypecode")
	@Expose
	private String fromcnttypecode;


	@SerializedName("uvs_workflowmapping.upduser")
	@Expose
	private String upduser;

	@SerializedName("uvs_workflowmapping.containerid")
	@Expose
	private String containerid;

	@SerializedName("uvs_workflowmapping.workflowid")
	@Expose
	private String workflowid;


	public String getBpmwrkflowid() {
		return bpmwrkflowid;
	}
	public void setBpmwrkflowid(String bpmwrkflowid) {
		this.bpmwrkflowid = bpmwrkflowid;
	}
	public String getCnttypecode() {
		return cnttypecode;
	}
	public void setCnttypecode(String cnttypecode) {
		this.cnttypecode = cnttypecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMdlcode() {
		return mdlcode;
	}
	public void setMdlcode(String mdlcode) {
		this.mdlcode = mdlcode;
	}
	public String getUpddate() {
		return upddate;
	}
	public void setUpddate(String upddate) {
		this.upddate = upddate;
	}
	public String getActive_status() {
		return active_status;
	}
	public void setActive_status(String active_status) {
		this.active_status = active_status;
	}
	public String getIsdynamicmdl() {
		return isdynamicmdl;
	}
	public void setIsdynamicmdl(String isdynamicmdl) {
		this.isdynamicmdl = isdynamicmdl;
	}
	public String getCruser() {
		return cruser;
	}
	public void setCruser(String cruser) {
		this.cruser = cruser;
	}
	public String getCrdate() {
		return crdate;
	}
	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}
	public String getFromcnttypecode() {
		return fromcnttypecode;
	}
	public void setFromcnttypecode(String fromcnttypecode) {
		this.fromcnttypecode = fromcnttypecode;
	}
	
	public String getUpduser() {
		return upduser;
	}
	public void setUpduser(String upduser) {
		this.upduser = upduser;
	}
	public String getContainerid() {
		return containerid;
	}
	public void setContainerid(String containerid) {
		this.containerid = containerid;
	}
	public String getWorkflowid() {
		return workflowid;
	}
	public void setWorkflowid(String workflowid) {
		this.workflowid = workflowid;
	}

}