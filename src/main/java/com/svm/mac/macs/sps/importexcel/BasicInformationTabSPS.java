package com.svm.mac.macs.sps.importexcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.svm.nfr.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author praveen s
 */
public class BasicInformationTabSPS implements Serializable {

    //1
    @SerializedName("vesselcode")
    @Expose
    private String vesselcode;

    // 2
    @SerializedName("vesselname")
    @Expose
    private String vesselname;

    // 3
    @SerializedName("vesseltypecode")
    @Expose
    private String vesselTypeCode;

    // 4
    @NotNull(message = "Fleet is required")
    private String fleetcode;

    // 5
    @NotNull(message = "Flag is required")
    @SerializedName("flag")
    @Expose
    private String flagcode;

    // 6
    @NotNull(message = "Type of Management is required")
    @SerializedName("type_mngmt")
    @Expose
    private String typeManagement;

    // 7
    @NotNull(message = "Port of Registry is required")
    @SerializedName("port_reg")
    @Expose
    private String portcode;

    // 8
    @NotNull(message = "Bussiness Section is required")
    @SerializedName("businesssection")
    @Expose
    private String businessSection;

    // 9
    @NotNull(message = "Management company is required")
    @SerializedName("shorecode")
    @Expose
    private String shorecode;

    // 10
    @NotNull(message = "Company IMONo is required")
    @SerializedName("company_imo")
    @Expose
    private String companyIMONo;

    // 11
    //@NotNull(message = "Former Management Company is required")
    @SerializedName("former_company")
    @Expose
    private String formerCompany;

    // 12
    @NotNull(message = "Company Account Code is required")
    @SerializedName("company_acccode")
    @Expose
    private String companyAccountCode;

    // 13
    @NotNull(message = "Owner Account Code is required")
    @SerializedName("owner_acccode")
    @Expose
    private String ownerAccountCode;

    // 14
    @NotNull(message = "Currency is required")
    @SerializedName("currency")
    @Expose
    private String currency;

    // 15
    @NotNull(message = "Financial Year End is required")
    @SerializedName("financialyearend")
    @Expose
    private String financialYearEnd;

    //16
    @NotNull(message = "Vessel Target is required")
    @SerializedName("vesselkpi")
    @Expose
    private Integer vesselkpi;

    // 17
    @NotNull(message = "Ship Yard is required")
    @SerializedName("shipyard")
    @Expose
    private String shipyard;

    // 18
    @SerializedName("built_date")
    @Expose
    private String dateOfBuilt;

    // 19
    @NotNull(message = "Age is required")
    @SerializedName("age")
    @Expose
    private Integer age;

    // 20
    @NotNull(message = "Hull No is required")
    @SerializedName("hullno")
    @Expose
    private String hullno;

    // 21
    @NotNull(message = "IMO No is required")
    @SerializedName("imono")
    @Expose
    private String imono;

    // 22
    @NotNull(message = "Official No is required")
    @SerializedName("officialno")
    @Expose
    private String officialno;

    // 23
    @NotNull(message = "Call Sign is required")
    @SerializedName("callsign")
    @Expose
    private String callsign;

    // 24
    @NotNull(message = "CBA/CA is required")
    @SerializedName("cba_ca")
    @Expose
    private String cbaca;

    // 25
    @NotNull(message = "Class is required")
    @SerializedName("class")
    @Expose
    private String clas;

    // 26
    @NotNull(message = "Class No is required")
    @SerializedName("classno")
    @Expose
    private String classno;

    //This Is for import from excel
    //27
    private String natrating;
    //28
    private int totalcrew;

    // 29
    @SerializedName("active_status")
    @Expose
    private String activeStatus;

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

    public String getVesselTypeCode() {
        return vesselTypeCode;
    }

    public void setVesselTypeCode(String vesselTypeCode) {
        this.vesselTypeCode = vesselTypeCode;
    }

    public String getFleetcode() {
        return fleetcode;
    }

    public void setFleetcode(String fleetcode) {
        this.fleetcode = fleetcode;
    }

    public String getFlagcode() {
        return flagcode;
    }

    public void setFlagcode(String flagcode) {
        this.flagcode = flagcode;
    }

    public String getTypeManagement() {
        return typeManagement;
    }

    public void setTypeManagement(String typeManagement) {
        this.typeManagement = typeManagement;
    }

    public String getPortcode() {
        return portcode;
    }

    public void setPortcode(String portcode) {
        this.portcode = portcode;
    }

    public String getBusinessSection() {
        return businessSection;
    }

    public void setBusinessSection(String businessSection) {
        this.businessSection = businessSection;
    }

    public String getShorecode() {
        return shorecode;
    }

    public void setShorecode(String shorecode) {
        this.shorecode = shorecode;
    }

    public String getCompanyIMONo() {
        return companyIMONo;
    }

    public void setCompanyIMONo(String companyIMONo) {
        this.companyIMONo = companyIMONo;
    }

    public String getFormerCompany() {
        return formerCompany;
    }

    public void setFormerCompany(String formerCompany) {
        this.formerCompany = formerCompany;
    }

    public String getCompanyAccountCode() {
        return companyAccountCode;
    }

    public void setCompanyAccountCode(String companyAccountCode) {
        this.companyAccountCode = companyAccountCode;
    }

    public String getOwnerAccountCode() {
        return ownerAccountCode;
    }

    public void setOwnerAccountCode(String ownerAccountCode) {
        this.ownerAccountCode = ownerAccountCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFinancialYearEnd() {
        return financialYearEnd;
    }

    public void setFinancialYearEnd(String financialYearEnd) {
        this.financialYearEnd = financialYearEnd;
    }

    public Integer getVesselkpi() {
        return vesselkpi;
    }

    public void setVesselkpi(Integer vesselkpi) {
        this.vesselkpi = vesselkpi;
    }

    public String getShipyard() {
        return shipyard;
    }

    public void setShipyard(String shipyard) {
        this.shipyard = shipyard;
    }

    public String getDateOfBuilt() {
        return dateOfBuilt;
    }

    public void setDateOfBuilt(String dateOfBuilt) {
        this.dateOfBuilt = dateOfBuilt;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHullno() {
        return hullno;
    }

    public void setHullno(String hullno) {
        this.hullno = hullno;
    }

    public String getImono() {
        return imono;
    }

    public void setImono(String imono) {
        this.imono = imono;
    }

    public String getOfficialno() {
        return officialno;
    }

    public void setOfficialno(String officialno) {
        this.officialno = officialno;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getCbaca() {
        return cbaca;
    }

    public void setCbaca(String cbaca) {
        this.cbaca = cbaca;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getNatrating() {
        return natrating;
    }

    public void setNatrating(String natrating) {
        this.natrating = natrating;
    }

    public int getTotalcrew() {
        return totalcrew;
    }

    public void setTotalcrew(int totalcrew) {
        this.totalcrew = totalcrew;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

}
